package com.csi.csi_demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//这里并不需要像mp官网那样添加扫描包

public class CsiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsiDemoApplication.class, args);
    }

}
