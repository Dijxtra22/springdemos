package com.example.websocketdemo.service;

import com.example.websocketdemo.controller.WebSocket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ScheduledTask {

    @Autowired
    WebSocket webSocket;

    static List<Long> secId = List.of(111L, 222L, 333L, 444L, 555L);

    @Scheduled(fixedRate = 5*1000)
    public void push2WebSocket(){
        log.info("job at " + LocalDateTime.now());
        secId.forEach(
                secId -> webSocket.pushBySecId(secId, LocalDateTime.now().toString())
        );
    }
}
