package com.example.javaexercise.spring_demo.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Slf4j
public class HelloController {

    @SneakyThrows
    @GetMapping("/sayHello")
    public String sayHello(String name) {
        log.info("sayHello");
        Thread.sleep(new Random().nextInt(5) * 1000);
        return "Hello " + name;
    }

    @SneakyThrows
    @GetMapping("/sayHi")
    public String sayHi(String name) {
        log.info("sayHi");
        Thread.sleep(new Random().nextInt(5) * 1000);
        return "Hi " + name;
    }
}
