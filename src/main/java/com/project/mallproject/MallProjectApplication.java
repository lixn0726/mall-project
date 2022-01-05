package com.project.mallproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.project.mallproject.core.repository.mapper") // 添加mapper扫描注解
public class MallProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallProjectApplication.class, args);
    }
}
