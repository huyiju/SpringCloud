package com.thit.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author :huyiju
 * @date :2020-04-29 16:02
 */
@WebFilter(filterName="secondFilter", urlPatterns="/*")
@Order(1)
@Slf4j
public class filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---初始化方法-----");
        log.info("---初始化方法-----");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;


        System.out.println("进入主方法:"+httpServletRequest.getMethod());
        System.out.println("filter获取参数是："+httpServletRequest.getParameter("name"));



        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {
        System.out.println("---销毁方法-----");
        log.info("---销毁方法-----");

    }
}
