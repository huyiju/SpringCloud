package com.thit.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :huyiju
 * @date :2020-04-15 17:55
 */
@RestController
@DefaultProperties(defaultFallback = "Global_time_out")
public class UserController {
    @Value("${server.port}")
    private  String port;
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        System.out.println("端口号3："+port);
        return "端口号123："+port;
    }

    @RequestMapping(value = "/add2/{name}",method = RequestMethod.GET)
    public String add1(@PathVariable(value = "name") String name){
        System.out.println("端口号："+name);
        return "名字:"+port+":"+name;
    }

    //服务降级 该服务超时3000毫秒没有返回值，或者代码出错  就会走time_out方法,
//    @HystrixCommand(fallbackMethod = "time_out", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000")
//    })

    @RequestMapping(value = "add1",method = RequestMethod.GET)
    @HystrixCommand
    public String add1(){
        int a=10/0;
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("服务睡眠端口号："+port);
        return "端口号:"+port;
    }
    public String time_out(){
        return "端口号："+port+Thread.currentThread().getName()+":服务异常,降级处理";
    }

    public String Global_time_out(){
        return "端口号："+port+Thread.currentThread().getName()+":全局设置服务异常,降级处理";
    }


}
