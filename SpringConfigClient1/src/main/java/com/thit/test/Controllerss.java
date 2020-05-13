package com.thit.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :huyiju
 * @date :2020-05-12 16:30
 */
@RestController
@RefreshScope  //动态刷新注解
public class Controllerss {
    @Value("${data.env}")
    private String aa;

    @Value("${aa}")
    private String a;

    @RequestMapping(value = "/add")
    public String add(){
        System.out.println("动态获取的值"+aa);
        System.out.println("动态获取的值a"+a);

        return aa;
    }
}
