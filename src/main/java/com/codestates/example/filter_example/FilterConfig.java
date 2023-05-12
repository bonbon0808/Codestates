package com.codestates.example.filter_example;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<FirstFilter> firstFilterFilterRegistration() {
        FilterRegistrationBean<FirstFilter> firstFilterFilterRegistrationBean = new FilterRegistrationBean<FirstFilter>(new FirstFilter());
        firstFilterFilterRegistrationBean.setOrder(1);
        return firstFilterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<SecondFilter> secondFilterFilterRegistration() {
        FilterRegistrationBean<SecondFilter> secondFilterFilterRegistrationBean = new FilterRegistrationBean<SecondFilter>(new SecondFilter());
        secondFilterFilterRegistrationBean.setOrder(2);
        return secondFilterFilterRegistrationBean;
    }
}
