package com.thit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :huyiju
 * @date :2020-04-15 17:55
 */
@RestController
public class UserController {
    @Value("${server.port}")
    private  String port;
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        System.out.println("consul8092端口号："+port);
        return "端口号:"+port;
    }

}
