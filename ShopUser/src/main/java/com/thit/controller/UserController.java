package com.thit.controller;

import com.thit.entity.Product;
import com.thit.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author :huyiju
 * @date :2020-04-09 18:36
 */
@RestController
public class UserController {
    Product p;
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("热部署");
        return "Hello 312313日期温热 dd!";
    }

    @RequestMapping(value = "/select/{id}",method = RequestMethod.GET)
    public String test1(@PathVariable("id") int id) {
        System.out.println("get请求");

        return "get请求传递参数："+id;
    }


    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String test2(@RequestBody  User u) {

        System.out.println("post请求");
        return u.toString();
    }

}
