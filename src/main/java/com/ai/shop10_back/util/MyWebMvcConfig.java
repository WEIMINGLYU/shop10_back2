package com.ai.shop10_back.util;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@SpringBootConfiguration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Resource
    private MyInterceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/user/login","/user/doLogin","/upload/**");
    }
}
