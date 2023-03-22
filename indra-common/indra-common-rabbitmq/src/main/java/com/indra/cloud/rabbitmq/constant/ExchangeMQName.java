package com.indra.cloud.rabbitmq.constant;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/20 19:33
 * @description: TODO
 */
public interface ExchangeMQName {

    /**
     * 前缀
     */
    String EX_PREFIX = "EX.";

    /**
     * 用户服务
     */
    String USER = "user";

    /**
     * 用户服务
     */
    String AUTH = "auth";

    /**
     * EX.user
     * 用户服务交换机
     */
    String USER_EXCHANGE = EX_PREFIX + USER;

    /**
     * EX.user.rollback.account
     * 从user服务发送回滚消息的交换机
     */
    String USER_ROLLBACK_EXCHANGE = USER_EXCHANGE + ".rollback.account";

}
