package com.qg.taxi.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 小铭
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.qg.taxi.service", "com.qg.taxi.util", "com.qg.taxi.dao", "com.qg.taxi.other"})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
