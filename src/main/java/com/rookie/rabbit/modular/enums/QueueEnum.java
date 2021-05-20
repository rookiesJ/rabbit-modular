package com.rookie.rabbit.modular.enums;

import com.rookie.rabbit.modular.util.RabbitArgumentBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sun.dc.pr.PRError;

import java.util.Map;

/**
 * @author rookie
 */

@Getter
@AllArgsConstructor
public enum QueueEnum {

    /**
     * 队列
     */
    EMAIL_PUSH("email-push-queue", 1, 0, "邮箱通知队列", "emailPushQueue",
            RabbitArgumentBuilder.build()
                    .addParam(RabbitArgumentEnum.X_MESSAGE_TTL, 10000)
                    .finish()
    ),

    SMS_PUSH("sms-push-queue", 1, 1, "短信通知队列", "smsPushQueue",
            RabbitArgumentBuilder.build()
                    .addParam(RabbitArgumentEnum.X_EXPIRES, 30000)
                    .finish()
    ),

    USER_ONE_QUEUE("user-one-queue", 1, 0, "用户1队列", "userOneQueue", null),

    USER_TWO_QUEUE("user-two-queue", 1, 0, "用户2队列", "userTwoQueue", null),

    USER_ORDER_QUEUE("user-order-queue", 1, 0, "用户下单队列", "userOrderQueue", null),

    USER_LOGOUT_QUEUE("user-logout-queue", 1, 0, "用户登出队列", "userLogoutQueue", null),

    SYSTEM_NOTICE_QUEUE("system-notice-queue", 1, 0, "系统通知队列", "systemNoticeQueue", null);

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

    /**
     * 配置附加参数
     */
    private Map<String, Object> args;

}
