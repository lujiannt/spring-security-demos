package com.example.demo5role1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo5role1.mapper")
public class Demo5Role1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo5Role1Application.class, args);
    }

}
