package com.rookie.rabbit.modular.entity;

import java.io.Serializable;

/**
 * @author rookie
 */
public interface IQueueMessage extends Serializable {

    /**
     * 获取 routing-key
     * @return routing-key
     */
    String getRoutingKey();

    /**
     * 获取交换机
     * @return 交换机
     */
    String getExchange();
}
