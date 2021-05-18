package com.rookie.rabbit.modular.entity;

import com.rookie.rabbit.modular.enums.BindEnum;
import com.rookie.rabbit.modular.enums.ExchangeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author rookie
 */
@Data
@Accessors(chain = true)
public class UserQueueMessage implements IQueueMessage{

    private String message;

    @Override
    public String getRoutingKey() {
        return BindEnum.USER_ONE_BIND.getKey();
    }

    @Override
    public String getExchange() {
        return ExchangeEnum.FANOUT_EXCHANGE.getName();
    }
}
