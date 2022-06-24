package com.example.logdemo.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("fooRepo")
@Slf4j
public class FooRepo {
    public void fooRepo(){
        log.trace("repo----");
        log.info("repo----");
        log.debug("repo----");
        log.warn("repo----");
        log.error("repo----");
    }
}
