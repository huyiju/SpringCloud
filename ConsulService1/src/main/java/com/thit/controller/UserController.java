package com.thit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author :huyiju
 * @date :2020-04-15 17:55
 */
@RestController
public class UserController {
    //使用eureka 注册管理服务  使用的是使用consul中的服务名字
    public static final String URL1="http://consulclients/add";

    @Autowired
    RestTemplate restTemplate1;

    @RequestMapping("/test")
    public String hello1() {
        String a= restTemplate1.getForObject(URL1,String.class);
        return a;
    }

}
