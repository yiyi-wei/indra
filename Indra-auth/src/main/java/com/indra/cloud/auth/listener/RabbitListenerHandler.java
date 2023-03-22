package com.indra.cloud.auth.listener;

import com.indra.cloud.auth.model.AuthAccount;
import com.indra.cloud.auth.service.AuthAccountService;
import com.indra.cloud.common.utils.BooleanUtil;
import com.indra.cloud.rabbitmq.constant.ExchangeMQName;
import com.indra.cloud.rabbitmq.constant.QueueMQName;
import com.indra.cloud.rabbitmq.constant.RoutingKeyMQName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/20 20:31
 * @description: TODO
 */
@Component
@Slf4j
public class RabbitListenerHandler {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private AuthAccountService authAccountService;

    @RabbitHandler
    @RabbitListener(queues = QueueMQName.USER_TO_AUTH_ROLLBACK_QUEUE)
    public void handleRollbackAccount(Long uid) {
        AuthAccount authAccount = authAccountService.getByUid(uid);
        // 说明没有增加成功，无需删除
        if(Objects.isNull(authAccount)) {
           return;
        }

        Integer deletedAuth = authAccountService.deleteAccountByUid(uid);
        log.info("分布式事务 --- MQ 回滚 account 表的操作: {}", BooleanUtil.isTrue(deletedAuth));
        if(BooleanUtil.isFalse(deletedAuth)) {
            amqpTemplate.convertAndSend(ExchangeMQName.USER_ROLLBACK_EXCHANGE, RoutingKeyMQName.USER_ROLLBACK_ROUTING_KEY, uid);
        }
    }
}
