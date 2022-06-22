package com.example.websocketdemo;

import com.example.websocketdemo.controller.WebSocket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebsocketDemoApplicationTests {
    @Autowired
    WebSocket webSocket;

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        //创建业务消息信息
//        JSONObject obj = new JSONObject();
//        obj.put("cmd", "topic");//业务类型
//        obj.put("msgId", sysAnnouncement.getId());//消息id
//        obj.put("msgTxt", sysAnnouncement.getTitile());//消息内容
////全体发送
//        webSocket.sendAllMessage(obj.toJSONString());
////单个用户发送 (userId为用户id)
//        webSocket.sendOneMessage(userId, obj.toJSONString());
////多个用户发送 (userIds为多个用户id，逗号‘,’分隔)
//        webSocket.sendMoreMessage(userIds, obj.toJSONString());

    }

}
