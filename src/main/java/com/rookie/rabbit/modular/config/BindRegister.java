package com.rookie.rabbit.modular.config;

import com.rookie.rabbit.modular.enums.BindEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BindRegister implements SmartInitializingSingleton {

    @Autowired
    private DefaultListableBeanFactory listableBeanFactory;

    @Override
    public void afterSingletonsInstantiated() {
        for (BindEnum value : BindEnum.values()) {
            Queue queue = getQueue(value.getQueueEnum().getBeanName());
            if (queue == null) {
                continue;
            }
            Exchange exchange = getExchange(value.getExchangeEnum().getBeanName());
            if (exchange == null) {
                continue;
            }
            BeanDefinitionBuilder rootBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Binding.class);
            rootBeanDefinition.addConstructorArgValue(value.getQueueEnum().getName());
            rootBeanDefinition.addConstructorArgValue(Binding.DestinationType.QUEUE);
            rootBeanDefinition.addConstructorArgValue(value.getExchangeEnum().getName());
            rootBeanDefinition.addConstructorArgValue(value.getKey());
            rootBeanDefinition.addConstructorArgValue(null);
            listableBeanFactory.registerBeanDefinition(value.getBeanName(), rootBeanDefinition.getBeanDefinition());
        }
    }

    private Queue getQueue(String beanName) {
        Object bean = null;
        try {
            bean = listableBeanFactory.getBean(beanName);
            if (!(bean instanceof Queue)) {
                return null;
            }
        } catch (BeansException e) {
            return null;
        }
        return (Queue) bean;
    }

    private Exchange getExchange(String beanName) {
        Object bean = null;
        try {
            bean = listableBeanFactory.getBean(beanName);
            if (!(bean instanceof Exchange)) {
                return null;
            }
        } catch (BeansException e) {
            return null;
        }
        return (Exchange) bean;
    }

}
