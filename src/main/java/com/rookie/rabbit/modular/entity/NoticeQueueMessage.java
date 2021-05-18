package com.rookie.rabbit.modular.entity;

import com.rookie.rabbit.modular.constant.TopicRoutingKeyConstant;
import com.rookie.rabbit.modular.enums.BindEnum;
import com.rookie.rabbit.modular.enums.ExchangeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author rookie
 */
@Data
@Accessors(chain = true)
public class NoticeQueueMessage implements IQueueMessage {

    private String message;

    @Override
    public String getRoutingKey() {
        return TopicRoutingKeyConstant.USER_ORDER_KEY;
    }

    @Override
    public String getExchange() {
        return ExchangeEnum.TOPIC_EXCHANGE.getName();
    }
}
