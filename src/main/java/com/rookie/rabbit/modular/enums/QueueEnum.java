package com.rookie.rabbit.modular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sun.dc.pr.PRError;

/**
 * @author rookie
 */

@Getter
@AllArgsConstructor
public enum QueueEnum {

    /**
     * 队列
     */
    EMAIL_PUSH("email-push-queue",1,0, "邮箱通知队列","emailPushQueue"),

    SMS_PUSH("sms-push-queue",1,0, "短信通知队列","smsPushQueue"),

    USER_ONE_QUEUE("user-one-queue",1,0, "用户1队列","userOneQueue"),

    USER_TWO_QUEUE("user-two-queue",1,0, "用户2队列","userTwoQueue"),

    USER_ORDER_QUEUE("user-order-queue",1,0, "用户下单队列","userOrderQueue"),

    USER_LOGOUT_QUEUE("user-logout-queue",1,0, "用户登出队列","userLogoutQueue"),

    SYSTEM_NOTICE_QUEUE("system-notice-queue",1,0, "系统通知队列","systemNoticeQueue");

    /**
     * 队列名称
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

    private String digest;

    private String beanName;
}
