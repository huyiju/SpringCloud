package com.thit.fencilent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :huyiju
 * @date :2020-04-09 18:09
 */

@SpringBootApplication
@ComponentScan(basePackages= {"com.thit"})
@EnableFeignClients //启动类 feign调用注解
@EnableCircuitBreaker //主启动类激活服务降级注解
@EnableHystrix  //断路器
//@EnableHystrixDashboard//监控注解
@ServletComponentScan("com.thit.filter")

public class Consumer2Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer2Application.class,args);
    }
}
