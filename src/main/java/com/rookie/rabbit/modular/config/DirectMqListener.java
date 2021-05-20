package com.rookie.rabbit.modular.config;

import com.rabbitmq.client.Channel;
import com.rookie.rabbit.modular.constant.QueueConstant;
import com.rookie.rabbit.modular.util.RabbitArgumentBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class DirectMqListener {

    @RabbitListener(queues = QueueConstant.EMAIL_PUSH_QUEUE)
    public void emailLister1(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        try {
            System.out.println("监听1：");
            System.out.println(message);
            channel.basicQos(1);
            channel.basicAck(tag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = QueueConstant.EMAIL_PUSH_QUEUE)
    public void emailLister2(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("监听2：");
        System.out.println(message);
        channel.basicAck(tag, false);

    }

    @RabbitListener(queues = QueueConstant.SMS_PUSH_QUEUE)
    public void smsLister(String message,Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println(1);
        System.out.println(message);
//        消息拒绝并且重新排队。
        channel.basicReject(tag,true);
//        channel.basicAck(tag, false);
    }
}
