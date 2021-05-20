package com.rookie.rabbit.modular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author rookie
 */

@Getter
@AllArgsConstructor
public enum RabbitArgumentEnum {

    /**
     * 附加参数
     */
    X_MESSAGE_TTL("x-message-ttl","消息失效时间"),

    X_EXPIRES("x-expires","队列失效时间"),

    X_MAX_LENGTH("x-max-length","队列消息最大数"),

    X_MAX_LENGTH_BYTES("x-max-length-bytes","队列最大字节数"),

    /**
     * drop-head（默认值，抛弃最旧的消息）
     * reject-publish（抛弃最新的消息）
     */
    X_OVERFLOW("x-overflow","溢出行为"),

    /**
     * lazy
     */
    X_QUEUE_MODE("x-queue-mode","懒加载队列"),

    X_DEAD_LETTER_EXCHANGE("x-dead-letter-exchange",""),

    X_DEAD_LETTER_ROUTING_KEY("x-dead-letter-routing-key",""),

    X_SINGLE_ACTIVE_CONSUMER("x-single-active-consumer",""),

    X_MAX_PRIORITY("x-max-priority",""),

    X_QUEUE_MASTER_LOCATOR("x-queue-master-locator","");


    private String id;

    private String digest;

}
