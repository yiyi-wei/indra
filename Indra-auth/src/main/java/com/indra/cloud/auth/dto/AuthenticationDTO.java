package com.indra.cloud.auth.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/16 18:26
 * @description: TODO
 */
@Data
public class AuthenticationDTO {
    /**
     * 用户名
     */
    @NotBlank(message = "principal不能为空")
    protected String principal;

    /**
     * 密码
     */
    @NotBlank(message = "credentials不能为空")
    protected String credentials;

    /**
     * sysType 参考SysTypeEnum
     */
    @NotNull(message = "sysType不能为空")
    protected Integer sysType;
}
