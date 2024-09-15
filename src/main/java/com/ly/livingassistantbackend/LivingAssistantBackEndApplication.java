package com.ly.livingassistantbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ly.livingassistantbackend.mapper")
public class LivingAssistantBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivingAssistantBackEndApplication.class, args);
    }

}
