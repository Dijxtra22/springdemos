package com.example.springboottestdemo;

import com.example.springboottestdemo.controller.DemoController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * SpringJUnit4ClassRunner.class:Spring运行环境
 * JUnit4.class:JUnit运行环境
 * SpringRunner.class:Spring Boot运行环境
 */
@RunWith(SpringRunner.class)
//标记为当前类为SpringBoot测试类，加载项目的ApplicationContext上下文环境
@SpringBootTest
class SpringbootTestDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private DemoController demoController;


    @Test
    public void testDemoController(){
        String s = demoController.helloBoot();
        System.out.println(s);
    }


}
