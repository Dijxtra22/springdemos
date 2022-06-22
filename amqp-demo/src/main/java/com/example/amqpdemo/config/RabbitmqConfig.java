package com.example.amqpdemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue testQueue1(){
        return new Queue("testQueue1", true);
    }

    @Bean
    public Queue testJsonQueue1(){
        return new Queue("testJsonQueue1", true);
    }

    /**
     * 配置接收的消息转换器
     * @return
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new FastJsonMessageConverter();
    }
}
