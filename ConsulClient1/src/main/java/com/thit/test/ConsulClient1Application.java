package com.thit.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :huyiju
 * @date :2020-04-09 18:09
 */

@SpringBootApplication
@ComponentScan(basePackages= {"com.thit"})
@EnableDiscoveryClient  //consul 这里必须使用EnableDiscoveryClient 注解
public class ConsulClient1Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsulClient1Application.class,args);
    }
}
