package com.thit.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author :huyiju
 * @date :2020-05-13 18:10
 */
@SpringBootApplication
@EnableEurekaClient
public class Main8004 {
    public static void main(String[] args)
    {
        SpringApplication.run(Main8004.class, args);
    }
}
