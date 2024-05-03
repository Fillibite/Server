package com.example.hackathon.global.auth.config;

import com.example.hackathon.global.auth.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<MyFilter> filter() {
        FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>(new MyFilter());
        bean.addUrlPatterns("/**");
        bean.setOrder(0);
        return bean;
    }
}
