package com.rookie.rabbit.modular;

import com.rookie.rabbit.modular.config.RabbitMqBeanDefinitionRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@Import(RabbitMqBeanDefinitionRegistrar.class)
@SpringBootApplication
public class RabbitModularApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitModularApplication.class, args);
    }

}
