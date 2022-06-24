package com.example.logdemo.controller;

import com.example.logdemo.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("fooController")
@Slf4j
public class FooController {

    @Autowired
    FooService fooService;

    public void fooController(){
        fooService.fooService();
        log.trace("controller----");
        log.info("controller----");
        log.debug("controller----");
        log.warn("controller----");
        log.error("controller----");
    }
}
