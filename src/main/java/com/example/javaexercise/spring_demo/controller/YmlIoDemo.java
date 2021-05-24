package com.example.javaexercise.spring_demo.controller;

import com.example.javaexercise.spring_demo.config.StudentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YmlIoDemo {
    /**
     * 通过@Value注解获取配置
     */
    @Value("${student.name}")
    String name;

    @Value("${student.sex}")
    String sex;

    @Value("${student.age}")
    Integer age;

    /**
     * 通过实体类注解获取配置
     */
    @Autowired
    StudentConfig studentConfig;

    @GetMapping("/getStudent")
    public String getStudent() {
        return "name: " + this.name + "\nsex: " + this.sex + "\nage" + this.age;
    }

    @GetMapping("/getStudentConfig")
    public StudentConfig getStudentConfig() {
        return this.studentConfig;
    }
}
