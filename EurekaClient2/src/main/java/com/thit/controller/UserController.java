package com.thit.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author :huyiju
 * @date :2020-04-15 17:55
 */
@RestController
public class UserController {

    @Value("${server.port}")
    private  String port;

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add(){
        System.out.println("端口号："+port);
        return "端口号:"+port;
    }

    @RequestMapping(value = "/add2/{name}",method = RequestMethod.GET)
    public String add1(@PathVariable(value = "name") String name,@RequestParam(value = "password") String password){
        System.out.println("端口号："+name);
        System.out.println("密码："+password);

        return "名字:"+port+":"+name;
    }




    /**
     * controller的add1方法，在给别人调用的时候可能会错和超时
     *
     * 服务降级 该服务超时3000毫秒没有返回值或者代码出错  就会走time_out方法,timeoutInMilliseconds 默认1秒
     * @return
     */
    @HystrixCommand(fallbackMethod = "time_out", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @RequestMapping(value = "add1",method = RequestMethod.GET)
    public String add1(){
        //服务超时  和服务出错 都会走fallbackMethod
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

}
