package com.wl.springbootdemo01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@MapperScan("com.wl.springbootdemo01.dao")
@EnableSwagger2
public class Springbootdemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootdemo01Application.class, args);
    }

}
