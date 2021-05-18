package com.rookie.rabbit.modular.config;

import com.rabbitmq.client.Channel;
import com.rookie.rabbit.modular.constant.QueueConstant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @author rookie
 */
@Component
public class TopicMqListener {

    @RabbitListener(queues = QueueConstant.USER_ORDER_QUEUE)
    public void userOrderQueue(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("用户下单队列：" + message);
        channel.basicAck(tag, false);
    }

    @RabbitListener(queues = QueueConstant.USER_LOGOUT_QUEUE)
    public void userLogoutLister(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("用户登出队列：" + message);
        channel.basicAck(tag, false);
    }

    @RabbitListener(queues = QueueConstant.SYSTEM_NOTICE_QUEUE)
    public void systemLister(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("系统通知队列：" + message);
        channel.basicAck(tag, false);
    }

}
