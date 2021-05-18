package com.rookie.rabbit.modular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author rookie
 */

@Getter
@AllArgsConstructor
public enum BindEnum {

    /**
     * 路由键
     */
    EMAIL_BIND("email.push.key", ExchangeEnum.DEFAULT_EXCHANGE, QueueEnum.EMAIL_PUSH, "emailBind"),

    SMS_BIND("sms.push.key", ExchangeEnum.DEFAULT_EXCHANGE, QueueEnum.SMS_PUSH, "smsBind"),

    USER_ONE_BIND("", ExchangeEnum.FANOUT_EXCHANGE, QueueEnum.USER_ONE_QUEUE, "userOneBind"),

    USER_TWO_BIND("", ExchangeEnum.FANOUT_EXCHANGE, QueueEnum.USER_TWO_QUEUE, "userTwoBind"),

    USER_ORDER_BIND("user.*.key", ExchangeEnum.TOPIC_EXCHANGE, QueueEnum.USER_ORDER_QUEUE, "userOrderBind"),

    USER_LOGOUT_BIND("user.*.key", ExchangeEnum.TOPIC_EXCHANGE, QueueEnum.USER_LOGOUT_QUEUE, "userLogoutBind"),

    SYSTEM_NOTICE_BIND("system.*.key", ExchangeEnum.TOPIC_EXCHANGE, QueueEnum.SYSTEM_NOTICE_QUEUE, "systemNoticeBind");

    private String key;

    private ExchangeEnum exchangeEnum;

    private QueueEnum queueEnum;

    private String beanName;
}
