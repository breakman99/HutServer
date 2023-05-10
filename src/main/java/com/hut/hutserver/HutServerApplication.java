package com.hut.hutserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;

@Primary
@SpringBootApplication
@MapperScan("com.hut.hutserver.mapper")
public class HutServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HutServerApplication.class, args);
    }

}
