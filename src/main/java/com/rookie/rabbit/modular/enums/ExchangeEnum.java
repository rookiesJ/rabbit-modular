package com.rookie.rabbit.modular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author rookie
 */
@Getter
@AllArgsConstructor
public enum ExchangeEnum {

    /**
     * 交换器列表
     */
    DEFAULT_EXCHANGE(1,"default_exchange",1,0,"默认交换器","defaultExchange"),

    FANOUT_EXCHANGE(2,"fanout_exchange",1,0,"fanout交换器","fanoutExchange"),

    TOPIC_EXCHANGE(3,"topic_exchange",1,0,"topic交换器","topicExchange");

    /**
     * 1:direct
     * 2:Fanout
     * 3、topic
     */
    private int type;

    /**
     * 交换器名称
     */
    private String name;

    /**
     * 是否持久化
     */
    private int durable;

    /**
     * 是否自动删除
     */
    private int autoDelete;

    /**
     * 描述
     */
    private String digest;

    /**
     * bean名称
     */
    private String beanName;


}
