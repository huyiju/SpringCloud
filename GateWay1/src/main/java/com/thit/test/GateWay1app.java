package com.thit.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author :huyiju
 * @date :2020-04-29 19:00
 */
@SpringBootApplication
@EnableEurekaClient

public class GateWay1app {
    public static void main(String[] args) {
        SpringApplication.run(GateWay1app.class,args);
    }

}
