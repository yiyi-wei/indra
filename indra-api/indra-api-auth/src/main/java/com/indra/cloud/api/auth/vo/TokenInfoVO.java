package com.indra.cloud.api.auth.vo;

import lombok.Data;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/16 18:29
 * @description: TODO
 */
@Data
public class TokenInfoVO {

    private String accessToken;

    private String refreshToken;

    /**
     * 在多少秒后过期
     */
    private Integer expiresIn;
}
