package com.indra.cloud.auth.feign;

import com.indra.cloud.api.auth.bo.UserInfoInTokenBO;
import com.indra.cloud.api.auth.constant.SysTypeEnum;
import com.indra.cloud.api.auth.dto.AuthAccountDTO;
import com.indra.cloud.api.auth.feign.AccountFeignClient;
import com.indra.cloud.api.auth.vo.AuthAccountVO;
import com.indra.cloud.api.auth.vo.TokenInfoVO;
import com.indra.cloud.api.leaf.feign.SegmentFeignClient;
import com.indra.cloud.auth.manager.TokenStore;
import com.indra.cloud.auth.mapper.AuthAccountMapper;
import com.indra.cloud.common.response.ServerResponseEntity;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FrozenWatermelon
 * @date 2020/9/22
 */
@RestController
public class AccountFeignController implements AccountFeignClient {

    @Autowired
    private AuthAccountMapper authAccountMapper;

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private SegmentFeignClient segmentFeignClient;


    @Override
    public ServerResponseEntity<Long> save(AuthAccountDTO authAccountDTO) {
        return null;
    }

    @Override
    public ServerResponseEntity<Void> update(AuthAccountDTO authAccountDTO) {
        return null;
    }

    @Override
    public ServerResponseEntity<Void> updateAuthAccountStatus(AuthAccountDTO authAccountDTO) {
        return null;
    }

    @Override
    public ServerResponseEntity<Void> deleteByUserIdAndSysType(Long userId) {
        return null;
    }

    @Override
    public ServerResponseEntity<AuthAccountVO> getByUserIdAndSysType(Long userId, Integer sysType) {
        return null;
    }

    @Override
    public ServerResponseEntity<TokenInfoVO> storeTokenAndGetVo(UserInfoInTokenBO userInfoInTokenBO) {
        return null;
    }

    @Override
    public ServerResponseEntity<AuthAccountVO> getByUsernameAndSysType(String username, SysTypeEnum sysType) {
        return null;
    }

    @Override
    public ServerResponseEntity<Void> updateUserInfoByUserIdAndSysType(UserInfoInTokenBO userInfoInTokenBO, Long userId, Integer sysType) {
        return null;
    }

    @Override
    public ServerResponseEntity<AuthAccountVO> getMerchantInfoByTenantId(Long tenantId) {
        return null;
    }
}
