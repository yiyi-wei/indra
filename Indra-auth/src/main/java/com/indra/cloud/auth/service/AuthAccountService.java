package com.indra.cloud.auth.service;

import com.indra.cloud.api.auth.bo.UserInfoInTokenBO;
import com.indra.cloud.auth.model.AuthAccount;
import com.indra.cloud.common.response.ServerResponseEntity;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/16 19:01
 * @description: TODO
 */
public interface AuthAccountService {

    /**
     * 通过输入的用户名密码，校验并获取部分用户信息
     * @param inputUserName 输入的用户名（用户名）
     * @param password 密码
     * @param sysType 系统类型 @see SysTypeEnum
     * @return 用户在token中信息
     */
    ServerResponseEntity<UserInfoInTokenBO> getUserInfoInTokenByInputUserNameAndPassword(String inputUserName,
                                                                                         String password, Integer sysType);

    /**
     * 根据用户id 和系统类型获取平台唯一用户
     * @param userId 用户id
     * @param sysType 系统类型
     * @return 平台唯一用户
     */
    AuthAccount getByUserIdAndType(Long userId, Integer sysType);

    /**
     * 更新密码 根据用户id 和系统类型
     * @param userId 用户id
     * @param sysType 系统类型
     * @param newPassWord 新密码
     */
    void updatePassword(Long userId, Integer sysType, String newPassWord);

    /**
     * 根据getByUid获取平台唯一用户
     *
     * @param uid  uid
     * @return 平台唯一用户
     */
    AuthAccount getByUid(Long uid);

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @param systemType 系统类型
     * @return uid
     */
    AuthAccount getAccountByInputUserName(String username, Integer systemType);

    /**
     * 根据uid删除用户，uid是唯一的不需要加系统类型
     * @param uid 用户唯一凭证
     * @return 影响的数据库行数
     */
    Integer deleteAccountByUid(Long uid);
}
