package com.thit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author :huyiju
 * @date :2020-04-15 17:55
 */
@RestController
public class UserController {

    //以前的是固定地址
   // public static final String URL1="http://localhost:8092/add";

    //使用eureka 注册管理服务  使用的是使用eureka地址
    public static final String URL1="http://CLIENT/add";

    @Autowired
    RestTemplate restTemplate1;

    @RequestMapping("/test")
    public String hello1() {
        String a= restTemplate1.getForObject(URL1,String.class);
        return a;
    }

    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping("/test1")
    public String hello2() {
        //获取所有的服务
        List<String> list= discoveryClient.getServices();
        for (String s:list){
            System.out.println(s);
        }
        //获取所有的实例
        List<ServiceInstance> list2= discoveryClient.getInstances("client");
        for (ServiceInstance s:list2){
            System.out.println("=============");
            System.out.println("getHost："+s.getHost());
            System.out.println("getInstanceId："+s.getInstanceId());
            System.out.println("getPort："+s.getPort());
            System.out.println("getServiceId："+s.getServiceId());
            System.out.println("getUri："+s.getUri());
        }
        return "11";
    }



}
