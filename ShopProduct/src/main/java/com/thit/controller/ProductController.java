package com.thit.controller;

import com.thit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author :huyiju
 * @date :2020-04-09 18:36
 */
@RestController
public class ProductController {
    public static final String URL1="http://localhost:8070/shopuser/select/9";

    public static final String URL2="http://localhost:8070/shopuser/create";

    @Autowired
    RestTemplate restTemplate1;

    @RequestMapping("/select")
    public String hello1() {

        System.out.println("商品业务查询");
       String a= restTemplate1.getForObject(URL1,String.class);
        System.out.println("用户返回值get："+a);
        return a;
    }


    @RequestMapping("/create")
    public String hello2() {
            User u=new User();
            u.setId(1);
            u.setUsername("jack");
            u.setPassword("111");
            u.setTelephone("13948712313");
        System.out.println("create");
      //  User u =new User();
//        User u=new User();
//        System.out.println("商品业务查询");
//        restTemplate1.postForObject(URL,);
        String a= restTemplate1.postForObject(URL2,u,String.class);
        return "post返回值"+a;
    }


}
