package com.thit.test;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * //全局过滤器，实现GlobalFilter接口，和Ordered接口即可。
 * @author :huyiju
 * @date :2020-04-29 22:55
 */
@Component
public class MyFilter1 implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("全局过滤器111");
        ServerHttpRequest request= exchange.getRequest();
        //获取token
       String token= request.getQueryParams().getFirst("token");
       if (token==null){
           ServerHttpResponse response = exchange.getResponse();
           //303状态码表示由于请求对应的资源存在着另一个URI，应使用GET方法定向获取请求的资源
           response.setStatusCode(HttpStatus.BAD_REQUEST);

           return response.setComplete();
       }
        System.out.println("aa:"+token);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
