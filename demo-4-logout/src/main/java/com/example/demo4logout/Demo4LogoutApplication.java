package com.example.demo4logout;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo4logout.mapper")
public class Demo4LogoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo4LogoutApplication.class, args);
    }

}
