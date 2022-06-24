package com.example.amqpdemo.mqtest;

import com.example.amqpdemo.productor.RabbitProduce;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@SpringBootTest
public class RabbitProduceTest {
    @Autowired
    private RabbitProduce rabbitProduce;
    @Autowired
    private RabbitTemplate rabbitTemplate;



    @Test
    public void sendSimpleMessage() {
        rabbitProduce.send();
        rabbitProduce.convertAndSend();
        rabbitProduce.sendObj();
    }

    @Test
    public void sendToExchangeWhichNoBindQueue(){
        for(int i = 0; i < 100; i++){
            // 消息直接丢失
            rabbitTemplate.convertAndSend("test-exchange-no-bind-queue", "", "hello"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testTopic(){
        CompletableFuture<Void> createOrderCF = CompletableFuture.runAsync(() -> generateOrder(20, "test.order.create"));
        CompletableFuture<Void> cancelOrderCF = CompletableFuture.runAsync(() -> generateOrder(20, "test.order.cancel"));
        CompletableFuture.allOf(createOrderCF, cancelOrderCF).whenComplete((v, e) -> System.out.println("done"+ Objects.requireNonNullElse(v, "")+Objects.requireNonNullElse(e, "")));
        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void generateOrder(int n, String routingKey){
        for(int i = 0; i < n; i++){
            rabbitTemplate.convertAndSend("test-topic-exchange-1", routingKey, "---"+routingKey+i);
        }
    }
}