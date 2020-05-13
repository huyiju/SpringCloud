package com.thit.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author :huyiju
 * @date :2020-05-12 14:22
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class AppTest {
    public static void main(String[] args) {
        SpringApplication.run(AppTest.class,args);

    }

}
