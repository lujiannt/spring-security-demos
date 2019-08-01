package com.example.demo3handler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo3handler.mapper")
public class Demo3HandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo3HandlerApplication.class, args);
    }

}
