package com.example.springboottestdemo.normal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootTest
public class NormalTest {

    public void task(){
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getThreadGroup());
            System.out.println(Thread.currentThread().toString());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        ExecutorService pool1 = Executors.newFixedThreadPool(5);
        ExecutorService pool2 = Executors.newFixedThreadPool(8);
        pool1.submit(this::task);
        pool2.submit(this::task);
    }
    @Test
    public void test2(){
        Integer a = 19999;
        Integer b = 19999;
        System.out.println(a.equals(b));
    }

}
