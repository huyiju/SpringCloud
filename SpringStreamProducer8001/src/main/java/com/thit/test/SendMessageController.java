package com.thit.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :huyiju
 * @date :2020-05-13 18:09
 */
@RestController
public class SendMessageController {
    @Autowired
    SendMessageImpl sendMessage;

    @RequestMapping(value = "/send")
    public String sendMessage() {
        //调用接口发送消息
        return sendMessage.send("测试");
    }


}
