package com.example.logdemo;

import com.example.logdemo.controller.FooController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class LogDemoApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(LogDemoApplication.class, args);
        log.trace("app----");
        log.info("app----");
        log.debug("app----");
        log.warn("app----");
        log.error("app----");
        run.getBean(FooController.class).fooController();
    }

}
