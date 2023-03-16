package com.indra.cloud.common.constant;

import com.indra.cloud.common.feign.FeignInsideAuthConfig;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/15 16:25
 * @description: TODO
 */
public interface Auth {
    String CHECK_TOKEN_URI = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/token/checkToken";

    String CHECK_RBAC_URI = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/insider/permission/checkPermission";
}
