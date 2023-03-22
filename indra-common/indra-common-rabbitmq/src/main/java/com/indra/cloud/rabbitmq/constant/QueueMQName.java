package com.indra.cloud.rabbitmq.constant;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/20 19:39
 * @description: TODO
 */
public interface QueueMQName {
    /**
     * 前缀
     */
    String MQ_PREFIX = "MQ.";

    /**
     * 用户服务
     */
    String USER = "user";

    /**
     * 用户服务
     */
    String AUTH = "auth";

    /**
     * MQ.user.auth
     * 从user服务向auth服务发送消息
     */
    String USER_QUEUE = MQ_PREFIX + USER + "." + AUTH;

    /**
     * MQ.user.auth.rollback.account
     * 从user服务向auth服务发送account表的注册信息回滚消息(注册回滚)
     */
    String USER_TO_AUTH_ROLLBACK_QUEUE = MQ_PREFIX + USER + "." + AUTH + ".rollback.account";
}
