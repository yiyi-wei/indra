package com.indra.cloud.auth.model;

import com.indra.cloud.common.model.BaseModel;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 统一账户信息
 * @TableName auth_account
 */
@Data
@Component
public class AuthAccount extends BaseModel implements Serializable {
    /**
     * 全平台用户唯一id
     */
    private Long uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建ip
     */
    private String createIp;

    /**
     * 状态 1:启用 0:禁用 -1:删除
     */
    private Integer status;

    /**
     * 用户类型见SysTypeEnum 0.普通用户系统 1.商家端 2平台端
     */
    private Integer sysType;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 所属租户
     */
    private Long tenantId;

    /**
     * 是否是管理员
     */
    private Integer isAdmin;

    private static final long serialVersionUID = 1L;
}