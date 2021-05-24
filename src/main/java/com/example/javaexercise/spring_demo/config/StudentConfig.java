package com.example.javaexercise.spring_demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "student")
public class StudentConfig {
    private String name;
    private String sex;
    private Integer age;

    @Value("${company}")
    private String company;
}
