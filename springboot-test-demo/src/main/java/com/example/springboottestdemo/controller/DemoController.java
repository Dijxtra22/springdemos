package com.example.springboottestdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String helloBoot(){
        return "hello123wqasdfasdfasfdsare";
    }

}
