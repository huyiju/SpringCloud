package com.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :huyiju
 * @date :2020-04-22 17:26
 */
@Configuration
public class MyRule {
    @Bean
    public IRule newrule(){
       //轮询算法 new RoundRobinRule();
        // 随机算法 new RandomRule
        //过滤多次故障 选择最小并发 new BestAvailableRule();
        return new RandomRule();

    }

}
