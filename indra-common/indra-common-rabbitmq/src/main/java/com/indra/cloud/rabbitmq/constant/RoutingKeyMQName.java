package com.indra.cloud.rabbitmq.constant;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/20 20:07
 * @description: TODO
 */
public interface RoutingKeyMQName {

    /**
     * 前缀
     */
    String ROUTING_KEY_PREFIX = "RK.";

    /**
     * 用户服务
     */
    String USER = "user";

    /**
     * 用户服务
     */
    String AUTH = "auth";

    /**
     * RK.user.rollback.account
     * user到auth路由的媒介
     */
    String USER_ROLLBACK_ROUTING_KEY = ROUTING_KEY_PREFIX + USER + ".rollback.account";
}
