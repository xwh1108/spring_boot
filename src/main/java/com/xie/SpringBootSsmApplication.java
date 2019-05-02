package com.xie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.xie.mapper")
public class SpringBootSsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSsmApplication.class, args);
    }

}
