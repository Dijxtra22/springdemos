package com.example.amqpdemo.config;

import org.springframework.amqp.core.*;
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

    @Bean
    public Exchange testExchangeNoBindQueue(){
        return new FanoutExchange("test-exchange-no-bind-queue");
    }

    /**
     * 配置接收的消息转换器
     * @return
     */
//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new FastJsonMessageConverter();
//    }

    @Bean
    public Exchange testTopicExchange(){
        return new TopicExchange("test-topic-exchange-1");
    }

    @Bean
    public Queue orderCreateQueue(){
        return new Queue("test-order-create-queue");
    }
    @Bean
    public Queue orderCancelQueue(){
        return new Queue("test-order-cancel-queue");
    }
    @Bean
    public Queue orderQueue(){
        return new Queue("test-all-order-queue");
    }

    @Bean
    public Binding bindOrderCreateQueue(Queue orderCreateQueue, Exchange testTopicExchange){
        return BindingBuilder.bind(orderCreateQueue).to(testTopicExchange).with("test.order.create").noargs();
    }
    @Bean
    public Binding bindOrderCancelQueue(Queue orderCancelQueue, Exchange testTopicExchange){
        return BindingBuilder.bind(orderCancelQueue).to(testTopicExchange).with("test.order.cancel").noargs();
    }    @Bean
    public Binding bindOrderQueue(Queue orderQueue, Exchange testTopicExchange){
        return BindingBuilder.bind(orderQueue).to(testTopicExchange).with("test.order.*").noargs();
    }
}
