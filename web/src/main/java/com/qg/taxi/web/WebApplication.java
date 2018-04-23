package com.qg.taxi.web;

import com.qg.taxi.model.StorageProperties;
import com.qg.taxi.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 小铭
 */
@SpringBootApplication
@ComponentScan("com.qg.taxi")
@EnableConfigurationProperties(StorageProperties.class)
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            // 删除全部文件
            storageService.deleteAll();
            // 初始化文件夹
            storageService.init();
        };
    }
}
