package com.rookie.rabbit.modular.config;

import com.rookie.rabbit.modular.entity.IQueueMessage;
import com.rookie.rabbit.modular.util.JsonUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqSendMessage {

    @Autowired
    private RabbitTemplate template;

    public void sendMsg(IQueueMessage message){
        template.convertAndSend(message.getExchange(),message.getRoutingKey(), JsonUtils.getJsonString(message));
    }
}
