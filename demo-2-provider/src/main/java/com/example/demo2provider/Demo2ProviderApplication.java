package com.example.demo2provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo2provider.mapper")
public class Demo2ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo2ProviderApplication.class, args);
    }

}
