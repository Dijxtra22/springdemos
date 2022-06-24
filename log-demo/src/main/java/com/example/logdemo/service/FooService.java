package com.example.logdemo.service;

import com.example.logdemo.repository.FooRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FooService {
    @Autowired
    FooRepo fooRepo;

    public void fooService(){
        fooRepo.fooRepo();
        log.trace("service----");
        log.info("service----");
        log.debug("service----");
        log.warn("service----");
        log.error("service----");
    }
}
