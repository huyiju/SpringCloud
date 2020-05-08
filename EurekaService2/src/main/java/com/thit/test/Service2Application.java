package com.thit.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :huyiju
 * @date :2020-04-09 18:09
 */

@SpringBootApplication
@ComponentScan(basePackages= {"com.thit"})
@EnableEurekaServer //此注解用来表示这是service
public class Service2Application {
    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class,args);
    }
}
