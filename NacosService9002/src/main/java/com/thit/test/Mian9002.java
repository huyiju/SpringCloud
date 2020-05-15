package com.thit.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author :huyiju
 * @date :2020-05-15 18:30
 */
@SpringBootApplication
@EnableDiscoveryClient //服务发现注解
public class Mian9002 {
    public static void main(String[] args) {
        SpringApplication.run(Mian9002.class,args);

    }


}
