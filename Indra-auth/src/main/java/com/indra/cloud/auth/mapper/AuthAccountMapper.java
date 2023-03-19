package com.indra.cloud.auth.mapper;

import com.indra.cloud.auth.model.AuthAccount;
import com.indra.cloud.common.security.bo.AuthAccountInVerifyBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 皮卡皮
* @description 针对表【auth_account(统一账户信息)】的数据库操作Mapper
* @createDate 2023-03-19 11:22:06
* @Entity com.indra.cloud.auth.model.AuthAccount
*/
@Mapper
public interface AuthAccountMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AuthAccount record);

    int insertSelective(AuthAccount record);

    AuthAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthAccount record);

    int updateByPrimaryKey(AuthAccount record);

    AuthAccountInVerifyBO getAuthAccountInVerifyByInputUserName(@Param("inputUserNameType") Integer inputUserNameType, @Param("inputUserName") String inputUserName, @Param("sysType") Integer sysType);

    /**
     * 根据用户id 和系统类型获取平台唯一用户
     *
     * @param userId  用户id
     * @param sysType 系统类型
     * @return 平台唯一用户
     */
    AuthAccount getByUserIdAndType(@Param("userId") Long userId, @Param("sysType") Integer sysType);

    /**
     * 根据getByUid获取平台唯一用户
     *
     * @param uid uid
     * @return 平台唯一用户
     */
    AuthAccount getByUid(@Param("uid") Long uid);

    /**
     * 更新密码 根据用户id 和系统类型
     *
     * @param userId      用户id
     * @param sysType     系统类型
     * @param newPassWord 新密码
     */
    void updatePassword(@Param("userId") Long userId, @Param("sysType") Integer sysType, @Param("newPassWord") String newPassWord);

    /**
     * 根据用户名和系统类型获取用户信息
     * @param validAccount
     * @param systemType
     * @return uid
     */
    AuthAccount getAccountByInputUserName(@Param("validAccount") String validAccount, @Param("systemType") Integer systemType);
}
