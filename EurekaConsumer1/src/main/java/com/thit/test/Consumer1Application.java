package com.thit.test;

import com.ribbon.MyRule1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :huyiju
 * @date :2020-04-09 18:09
 */

@SpringBootApplication
@ComponentScan(basePackages= {"com.thit"})
@EnableEurekaClient  //客户端需要EnableEurekaClient注解
@RibbonClient(name = "CLIENT",configuration = MyRule1.class) //自定义负载均称

public class Consumer1Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer1Application.class,args);
    }
}
