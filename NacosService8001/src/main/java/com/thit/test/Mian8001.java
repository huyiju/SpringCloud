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
public class Mian8001 {
    public static void main(String[] args) {
        System.out.println("1111");
        //System.out.println("服务器");
        SpringApplication.run(Mian8001.class,args);

    }


}
