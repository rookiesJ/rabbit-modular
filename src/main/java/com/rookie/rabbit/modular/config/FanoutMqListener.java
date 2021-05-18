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
public class FanoutMqListener {

    @RabbitListener(queues = QueueConstant.USER_ONE_QUEUE)
    public void userOneLister(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("用户1队列：" + message);
        channel.basicAck(tag, false);
    }

    @RabbitListener(queues = QueueConstant.USER_TWO_QUEUE)
    public void userTwoLister(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("用户2队列：" + message);
        channel.basicAck(tag, false);
    }

}
