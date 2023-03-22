package com.indra.cloud.rabbitmq.config;

import com.indra.cloud.rabbitmq.constant.ExchangeMQName;
import com.indra.cloud.rabbitmq.constant.QueueMQName;
import com.indra.cloud.rabbitmq.constant.RoutingKeyMQName;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/20 8:55
 * @description: RabbitMQConfig
 */
@Configuration
public class RabbitMQConfig {

    /**
     * user服务需要将回滚account表的消息通过交换机传递
     * @return 直连交换机
     */
    @Bean
    public Exchange accountRollbackInUserExchange() {
        return new DirectExchange(ExchangeMQName.USER_ROLLBACK_EXCHANGE);
    }

    /**
     * user服务需要将回滚account表的消息通过队列的方式传递给auth
     * @return 队列Queue
     */
    @Bean
    public Queue accountRollbackInUser2authQueue() {
        return new Queue( QueueMQName.USER_TO_AUTH_ROLLBACK_QUEUE);
    }

    /**
     * user到auth路由指向
     * @return 绑定路由键
     */
    @Bean
    public Binding authAndUserBinding() {
        return BindingBuilder.bind(accountRollbackInUser2authQueue())
                .to(accountRollbackInUserExchange())
                .with(RoutingKeyMQName.USER_ROLLBACK_ROUTING_KEY).noargs();

    }

    /**
     * 一方面它可以把我们的非标准化Message对象转换成我们的目标Message对象，这主要是用在发送消息的时候；
     * 另一方面它又可以把我们的Message对象转换成对应的目标对象，这主要是用在接收消息的时候。
     * @return Json方式
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }
}
