package com.thit.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author :huyiju
 * @date :2020-05-12 14:22
 */
@SpringBootApplication
@EnableEurekaClient
public class AppTestService2 {
    public static void main(String[] args) {
        SpringApplication.run(AppTestService2.class,args);

    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
//
//        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
//
//        c.setIgnoreUnresolvablePlaceholders(true);
//
//        return c;
//
//    }

}
