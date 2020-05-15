package com.thit.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :huyiju
 * @date :2020-05-15 21:03
 */
@RestController
public class Controller {

    @Value("${server.port}")
    String port;
    @RestController
    public class add {
        @GetMapping(value = "/add")
        public String add() {

            return "服务端nocas端口号:"+port;
        }
    }

}
