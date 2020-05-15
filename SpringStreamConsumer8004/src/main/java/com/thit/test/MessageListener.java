package com.thit.test;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author :huyiju
 * @date :2020-05-13 18:31
 */
@Component
@EnableBinding(Sink.class) //消费者注解
public class MessageListener {

    @StreamListener(Sink.INPUT)//消费者注解监听
    public void receive(Message<String> message){
        System.out.println("消费值8004接收到消息："+message.getPayload());

    }
}
