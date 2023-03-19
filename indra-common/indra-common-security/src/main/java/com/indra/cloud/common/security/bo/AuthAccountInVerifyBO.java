package com.indra.cloud.common.security.bo;

import com.indra.cloud.api.auth.bo.UserInfoInTokenBO;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/16 19:52
 * @description: TODO
 */
@Data
@Component
public class AuthAccountInVerifyBO extends UserInfoInTokenBO {
    private String password;

    private Integer status;
}
