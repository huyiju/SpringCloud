package com.thit.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :huyiju
 * @date :2020-04-09 18:09
 */

@SpringBootApplication
@ComponentScan(basePackages= {"com.thit"})
@EnableEurekaClient  //客户端需要EnableEurekaClient注解
@EnableCircuitBreaker //主启动类激活服务降级注解

public class Client2Application {

    public static void main(String[] args) {
        SpringApplication.run(Client2Application.class,args);
    }
}
