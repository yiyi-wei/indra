package com.indra.cloud.user.controller;

import cn.hutool.core.util.StrUtil;
import com.indra.cloud.api.auth.bo.UserInfoInTokenBO;
import com.indra.cloud.api.auth.constant.SysTypeEnum;
import com.indra.cloud.api.auth.feign.AccountFeignClient;
import com.indra.cloud.api.auth.vo.TokenInfoVO;
import com.indra.cloud.common.response.ResponseEnum;
import com.indra.cloud.common.response.ServerResponseEntity;
import com.indra.cloud.user.dto.UserRegisterDTO;
import com.indra.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *
 * 用户注册接口
 *
 * @Author: 魏一yi
 * @Date: 2023/3/20 10:40
 * @description: TODO
 */
@RestController
@RequestMapping("/ua/user/register")
public class UserRegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountFeignClient accountFeignClient;

    /**
     * 注册
     */
    @PostMapping
    public ServerResponseEntity<TokenInfoVO> register(@Valid @RequestBody UserRegisterDTO param) {

        if (StrUtil.isBlank(param.getNickName())) {
            param.setNickName(param.getUserName());
        }
        // 1. 保存账户信息
        ServerResponseEntity<Long> uid = userService.save(param);
        if(!uid.isSuccess()) {
            return ServerResponseEntity.fail(ResponseEnum.EXCEPTION);
        }
        // 2. 登录
        UserInfoInTokenBO userInfoInTokenBO = new UserInfoInTokenBO();
        userInfoInTokenBO.setUid(uid.getData());
        userInfoInTokenBO.setUserId(param.getUserId());
        userInfoInTokenBO.setSysType(SysTypeEnum.ORDINARY.value());
        userInfoInTokenBO.setIsAdmin(0);
        return accountFeignClient.storeTokenAndGetVo(userInfoInTokenBO);
    }

}