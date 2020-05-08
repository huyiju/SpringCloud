package com.thit.fencilent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author :huyiju
 * @date :2020-04-15 17:55
 */


@FeignClient(value = "client")  //value的名字是eureka中注册的名字

public interface UserControllerClient {

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add();

    @RequestMapping(value = "add1",method = RequestMethod.GET)
    public String add1();
}
