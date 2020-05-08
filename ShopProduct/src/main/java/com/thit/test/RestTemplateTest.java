package com.thit.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author :huyiju
 * @date :2020-04-10 17:11
 */
@Configuration //由多个bean的时候使用
public class RestTemplateTest {

//
//<beans>
//    <bean id="restTemplate1" class="com.thit.test.RestTemplateTest"/>
//</beans>

    @Bean //方法名字就是bean的名字（"方法名字"）
    public RestTemplate restTemplate1(){
        return new RestTemplate();
    }

    @Bean
    public RestTemplate restTemplate2(){
        return new RestTemplate();
    }


}
