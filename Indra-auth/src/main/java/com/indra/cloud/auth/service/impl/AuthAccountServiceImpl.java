package com.indra.cloud.auth.service.impl;

import cn.hutool.core.util.StrUtil;
import com.indra.cloud.api.auth.bo.UserInfoInTokenBO;
import com.indra.cloud.auth.constant.AuthAccountStatusEnum;
import com.indra.cloud.auth.mapper.AuthAccountMapper;
import com.indra.cloud.auth.model.AuthAccount;
import com.indra.cloud.auth.service.AuthAccountService;
import com.indra.cloud.common.response.ServerResponseEntity;
import com.indra.cloud.common.security.bo.AuthAccountInVerifyBO;
import com.indra.cloud.common.security.constant.InputUserNameEnum;
import com.indra.cloud.common.utils.PrincipalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/16 19:01
 * @description: TODO
 */
@Service
@Slf4j
public class AuthAccountServiceImpl implements AuthAccountService {

    @Autowired
    private AuthAccountMapper authAccountMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static final String USER_NOT_FOUND_SECRET = "USER_NOT_FOUND_SECRET";

    private static String userNotFoundEncodedPassword;

    @Override
    public ServerResponseEntity<UserInfoInTokenBO> getUserInfoInTokenByInputUserNameAndPassword(String inputUserName, String password, Integer sysType) {

        if(StrUtil.isBlank(inputUserName)) {
            return ServerResponseEntity.showFailMsg("用户名不能为空");
        }
        if(StrUtil.isBlank(password)) {
            return ServerResponseEntity.showFailMsg("密码不能为空");
        }

        InputUserNameEnum inputUserNameEnum = null;

        // 用户名
        if(PrincipalUtil.isUserName(inputUserName)) {
            inputUserNameEnum = InputUserNameEnum.USERNAME;
        }

        if(inputUserNameEnum == null) {
            return ServerResponseEntity.showFailMsg("请输入正确的用户名");
        }

        AuthAccountInVerifyBO authAccountInVerifyBO = authAccountMapper
                .getAuthAccountInVerifyByInputUserName(inputUserNameEnum.value(), inputUserName, sysType);

        if(authAccountInVerifyBO == null) {
            prepareTimingAttackProtection();
            // 再次进行运算，防止计时攻击
            // 计时攻击（Timing
            // attack），通过设备运算的用时来推断出所使用的运算操作，或者通过对比运算的时间推定数据位于哪个存储设备，或者利用通信的时间差进行数据窃取。
            mitigateAgainstTimingAttack(password);
            return ServerResponseEntity.showFailMsg("用户名或密码不正确");
        }

        if(Objects.equals(authAccountInVerifyBO.getStatus(), AuthAccountStatusEnum.DISABLE.value())) {
            return ServerResponseEntity.showFailMsg("用户已禁用，请联系客服");
        }

        if(!passwordEncoder.matches(password, authAccountInVerifyBO.getPassword())) {
            return ServerResponseEntity.showFailMsg("用户名或密码不正确");
        }

        // 参数整理
        UserInfoInTokenBO userInfoInTokenBO = new UserInfoInTokenBO();
        BeanUtils.copyProperties(authAccountInVerifyBO, userInfoInTokenBO);

        return ServerResponseEntity.success(userInfoInTokenBO);
    }

    @Override
    public AuthAccount getByUserIdAndType(Long userId, Integer sysType) {
        return authAccountMapper.getByUserIdAndType(userId, sysType);
    }

    @Override
    public void updatePassword(Long userId, Integer sysType, String newPassWord) {
        authAccountMapper.updatePassword(userId, sysType, passwordEncoder.encode(newPassWord));
    }

    @Override
    public AuthAccount getByUid(Long uid) {
        return authAccountMapper.getByUid(uid);
    }


    @Override
    public AuthAccount getAccountByInputUserName(String username, Integer systemType) {
        return authAccountMapper.getAccountByInputUserName(username, systemType);
    }


    /**
     * 防止计时攻击
     */
    private void prepareTimingAttackProtection() {
        if(userNotFoundEncodedPassword == null) {
            userNotFoundEncodedPassword = this.passwordEncoder.encode(USER_NOT_FOUND_SECRET);
        }
    }

    /**
     * 防止计时攻击
     */
    private void mitigateAgainstTimingAttack(String presentedPassword) {
        if(presentedPassword != null) {
            this.passwordEncoder.matches(presentedPassword, userNotFoundEncodedPassword);
        }
    }


}
