package com.indra.cloud.user.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户注册信息
 * 
 * @Author: 魏一yi
 * @Date: 2023/3/20 10:56
 * @description: TODO
 */
@Data
public class UserRegisterDTO {

    @NotBlank
    /**密码*/
    private String password;

    /**头像*/
    private String img;

    /**昵称*/
    private String nickName;

    @NotBlank
    /**用户名*/
    private String userName;

    /**当账户未绑定时，临时的uid*/
    private String tempUid;

    /**用户id*/
    private Long userId;
}
