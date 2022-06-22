package com.example.amqpdemo.consumer;

import com.example.amqpdemo.config.Producer;
import com.example.amqpdemo.pojo.User;
import com.example.amqpdemo.pojo.UserUnserialize;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component("rabbitConsumer")
@RabbitListener(queues = {Producer.QUEUE_NAME, Producer.QUEUE_NAME_JSON})
public class RabbitConsumer {

    @RabbitHandler
    public void onMessage(Message message, Channel channel, @Payload String msg, @Headers Map<String, Object> headers) throws Exception {
        System.out.println(msg);
        System.out.println("headers: " + headers);
        System.out.println("Message content : " + message);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        System.out.println("消息已确认");
    }
    @RabbitHandler
    public void onMessageJson(Message message, Channel channel, @Payload User msg) throws Exception {
        System.out.println(msg);
        System.out.println("Message content : " + message);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        System.out.println("消息已确认");
    }
    @RabbitHandler
    public void onMessageObj(Message message, Channel channel, @Payload UserUnserialize msg) throws Exception {
        System.out.println(msg);
        System.out.println("Message content : " + message);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        System.out.println("消息已确认");
    }
}
