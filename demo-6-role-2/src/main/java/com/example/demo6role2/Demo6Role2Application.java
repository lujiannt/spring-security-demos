package com.example.demo6role2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo6role2.mapper")
public class Demo6Role2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo6Role2Application.class, args);
    }

}
