package com.thit.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :huyiju
 * @date :2020-04-09 18:09
 */

@SpringBootApplication
@ComponentScan(basePackages= {"com.thit"})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
