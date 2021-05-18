package com.rookie.rabbit.modular.config;

import com.rookie.rabbit.modular.enums.ExchangeEnum;
import com.rookie.rabbit.modular.enums.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author rookie
 */
public class RabbitMqBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        registerExchange(registry);
        registerQueue(registry);
    }

    /**
     * 注册交换器
     *
     * @param registry BeanDefinitionRegistry
     */
    private void registerExchange(BeanDefinitionRegistry registry) {
        for (ExchangeEnum value : ExchangeEnum.values()) {
            BeanDefinitionBuilder rootBeanDefinition = null;

            if (value.getType() == 1) {
                rootBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(DirectExchange.class);
            } else if (value.getType() == 2) {
                rootBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(FanoutExchange.class);
            } else if (value.getType() == 3) {
                rootBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(TopicExchange.class);
            } else {
                rootBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(DirectExchange.class);
            }

            rootBeanDefinition.addConstructorArgValue(value.getName());
            rootBeanDefinition.addConstructorArgValue(getBooleanValue(value.getDurable()));
            rootBeanDefinition.addConstructorArgValue(getBooleanValue(value.getAutoDelete()));
            registry.registerBeanDefinition(value.getBeanName(), rootBeanDefinition.getBeanDefinition());
        }
    }

    /**
     * 注册队列
     * @param registry BeanDefinitionRegistry
     */
    private void registerQueue(BeanDefinitionRegistry registry) {
        for (QueueEnum value : QueueEnum.values()) {
            BeanDefinitionBuilder rootBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Queue.class);
            rootBeanDefinition.addConstructorArgValue(value.getName());
            rootBeanDefinition.addConstructorArgValue(getBooleanValue(value.getDurable()));
            rootBeanDefinition.addConstructorArgValue(false);
            rootBeanDefinition.addConstructorArgValue(getBooleanValue(value.getAutoDelete()));
            registry.registerBeanDefinition(value.getBeanName(), rootBeanDefinition.getBeanDefinition());
        }
    }

    private Boolean getBooleanValue(int value) {
        if (value == 0) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }
}
