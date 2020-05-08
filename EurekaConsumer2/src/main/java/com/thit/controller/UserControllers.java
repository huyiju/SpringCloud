package com.thit.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.thit.fencilent.UserControllerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :huyiju
 * @date :2020-04-15 17:55
 */
@RestController
@DefaultProperties(defaultFallback = "adefaultFallback")
public class UserControllers {

   @Autowired
   UserControllerClient userControllerClient;

    @RequestMapping("/test")
    public String hello1() {
        //调用远程controller跟调用本地方法似的，此处思想跟dubbo一致
       String a= userControllerClient.add();
        return "openfign调用轮询接口:"+a;
    }

    @RequestMapping("/test2")
    @HystrixCommand
    public String hello2() {
        //调用远程controller跟调用本地方法似的，此处思想跟dubbo一致
        String a= userControllerClient.add1();
        return "openfign调用超时接口:"+a;
    }

    public String adefaultFallback() {
        //调用远程controller跟调用本地方法似的，此处思想跟dubbo一致
        return "调用方异常8072"+Thread.currentThread().getName();

    }

    /**
     * 熔断方法 指定fallback方法可参数
     * id参数为-  代码抛出异常,在10秒内10此请求以上如果错误率60以上就会触发断路器，导致服务不可用
     * @param id
     * @return
     */
    @RequestMapping("/test3/{id}")
//    @HystrixCommand(fallbackMethod = "back1",commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//打开断路器
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//阀值，判断熔断的最少请求数，默认是10；只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//快照时间，默认10秒 10秒以内阀值10以上 成功率60一下会熔断
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//表示在一个统计窗口内有50%的请求处理失败，会触发熔断
//
//    })
    @HystrixCommand(fallbackMethod = "back1")
    public String hello3(@PathVariable("id") int id) {
        System.out.println("默认断路器打开");
        if (id > 0) {
            System.out.println("断路器关闭,直接返回");
            return "断路器关闭,直接返回";
        }
        else {
            //参数为-  代码抛出异常,在10秒内10此请求以上如果错误率60以上就会触发断路器，导致服务不可用
            System.out.println("断路器打开,开启熔断");
            throw  new RuntimeException();

        }

    }

    public  String back1(@PathVariable("id") int id){
        return "----服务熔断处理------";
    }




    //限流策略：线程池方式
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000"),
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD")//线程池
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "3"),//核心线程
                    @HystrixProperty(name = "maxQueueSize", value = "5"),//最大线程数
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "100")//等待队列
            },
            fallbackMethod = "back2"
    )
    @RequestMapping("/test4")
    public String test4() {
        System.out.println("线程id:"+Thread.currentThread().getId()+"："+Thread.currentThread().getName());

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "下单成功，订单号是:";
    }

    public String back2()  {
        System.err.println("-------超时线程池降级策略执行------------");
        return "-------超时线程池降级策略执行------------";
    }


    /**
     * 信号量SEMAPHORE
     * @return
     */
    @HystrixCommand(
            commandKey="test5",
            commandProperties= {
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"),//信号量
                    @HystrixProperty(name="execution.isolation.semaphore.maxConcurrentRequests", value="6")//6个信号
            },

            fallbackMethod = "back3"
    )
    @RequestMapping("/test5")
    public String test5() {
        System.out.println("信号量线程id:"+Thread.currentThread().getId()+"："+Thread.currentThread().getName());

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "信号量执行策略";
    }

    public String back3()  {
        System.err.println("-------信号量执行策略------------");
        return "-------信号量执行------------";
    }


    @RequestMapping(value = "/add")
    public String add(String name){
        System.out.println("获controller取参数是："+name);

        return "接受到的name是："+name;
    }


}
