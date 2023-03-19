package com.indra.cloud.auth.controller;

import com.indra.cloud.api.auth.bo.UserInfoInTokenBO;
import com.indra.cloud.api.auth.vo.TokenInfoVO;
import com.indra.cloud.api.rbac.dto.ClearUserPermissionsCacheDTO;
import com.indra.cloud.api.rbac.feign.PermissionFeignClient;
import com.indra.cloud.auth.dto.AuthenticationDTO;
import com.indra.cloud.auth.manager.TokenStore;
import com.indra.cloud.auth.mapper.AuthAccountMapper;
import com.indra.cloud.auth.service.impl.AuthAccountServiceImpl;
import com.indra.cloud.common.response.ServerResponseEntity;
import com.indra.cloud.common.security.AuthUserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author FrozenWatermelon
 * @date 2020/6/30
 */
@RestController
public class LoginController {

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private AuthAccountServiceImpl authAccountService;

	@Autowired
	private PermissionFeignClient permissionFeignClient;

	@Autowired
	private AuthAccountMapper authAccountMapper;

	@PostMapping("/ua/login")
	public ServerResponseEntity<TokenInfoVO> login(
			@Valid @RequestBody AuthenticationDTO authenticationDTO) {

		// 这边获取了用户的用户信息，那么根据sessionId对应一个user的原则，我应该要把这个东西存起来，然后校验，那么存到哪里呢？
		// redis，redis有天然的自动过期的机制，有key value的形式
		ServerResponseEntity<UserInfoInTokenBO> userInfoInTokenResponse = authAccountService
				.getUserInfoInTokenByInputUserNameAndPassword(authenticationDTO.getPrincipal(),
						authenticationDTO.getCredentials(), authenticationDTO.getSysType());

		if (!userInfoInTokenResponse.isSuccess()) {
			return ServerResponseEntity.transform(userInfoInTokenResponse);
		}

		UserInfoInTokenBO data = userInfoInTokenResponse.getData();

		ClearUserPermissionsCacheDTO clearUserPermissionsCacheDTO = new ClearUserPermissionsCacheDTO();
		clearUserPermissionsCacheDTO.setSysType(data.getSysType());
		clearUserPermissionsCacheDTO.setUserId(data.getUserId());

		// TODO 将以前的权限清理了,以免权限有缓存
		// ServerResponseEntity<Void> clearResponseEntity = permissionFeignClient.clearUserPermissionsCache(clearUserPermissionsCacheDTO);

		// if (!clearResponseEntity.isSuccess()) {
		// 	return ServerResponseEntity.fail(ResponseEnum.UNAUTHORIZED);
		// }


		// 保存token，返回token数据给前端，这里是最重要的
		return ServerResponseEntity.success(tokenStore.storeAndGetVo(data));
	}

	@PostMapping("/login_out")
	public ServerResponseEntity<TokenInfoVO> loginOut() {
		UserInfoInTokenBO userInfoInToken = AuthUserContext.get();
		ClearUserPermissionsCacheDTO clearUserPermissionsCacheDTO = new ClearUserPermissionsCacheDTO();
		clearUserPermissionsCacheDTO.setSysType(userInfoInToken.getSysType());
		clearUserPermissionsCacheDTO.setUserId(userInfoInToken.getUserId());
		// 将以前的权限清理了,以免权限有缓存
		permissionFeignClient.clearUserPermissionsCache(clearUserPermissionsCacheDTO);
		// 删除该用户在该系统的token
		tokenStore.deleteAllToken(userInfoInToken.getSysType().toString(), userInfoInToken.getUid());
		return ServerResponseEntity.success();
	}

}
