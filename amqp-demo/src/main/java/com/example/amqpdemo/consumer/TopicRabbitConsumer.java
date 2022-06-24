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
@Component("topicRabbitConsumer")
@RabbitListener(queues = {"test-order-create-queue", "test-order-cancel-queue", "test-all-order-queue"})
public class TopicRabbitConsumer {

    @RabbitHandler
    public void onMessage(Message message, Channel channel, @Payload String msg, @Headers Map<String, Object> headers) throws Exception {
        System.out.println(msg);
        System.out.println("headers: " + headers);
        System.out.println("Message content : " + message);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        System.out.println("消息已确认");
    }
}
