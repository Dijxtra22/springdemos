package com.example.amqpdemo.productor;

import com.example.amqpdemo.config.Producer;
import com.example.amqpdemo.pojo.User;
import com.example.amqpdemo.pojo.UserUnserialize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;


@Slf4j
@Component("rabbitProduce")
public class RabbitProduce {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send() {
        String message = "Hello this is a test message at " + LocalDateTime.now().toString();

        System.out.println("Message content : " + message);

        // 指定消息类型
        MessageProperties props = MessagePropertiesBuilder.newInstance()
                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN).build();

        rabbitTemplate.send(Producer.QUEUE_NAME,new Message(message.getBytes(StandardCharsets.UTF_8),props));
        System.out.println("消息发送完毕。");
    }

    public void convertAndSend() {
        User user = new User(1L, "testUser");

        System.out.println("Message content : " + user);

        rabbitTemplate.convertAndSend(Producer.QUEUE_NAME_JSON,user);
        System.out.println("消息发送完毕。");
    }

    public void sendObj(){
        UserUnserialize user = new UserUnserialize(ThreadLocalRandom.current().nextLong(), ThreadLocalRandom.current().toString());
        System.out.println("Message content : " + user);
        rabbitTemplate.convertAndSend(Producer.QUEUE_NAME_JSON2,user);
        System.out.println("消息发送完毕。");
    }

}
