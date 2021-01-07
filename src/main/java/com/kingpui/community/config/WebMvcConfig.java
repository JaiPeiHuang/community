package com.kingpui.community.config;

import com.kingpui.community.controller.interceptor.*;
import com.kingpui.community.service.StatisticsUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginTicketInterceptor loginTicketInterceptor;

    @Autowired
    private AlphaInterceptor alphaInterceptor;

//    @Autowired
//    private LoginRequiredInterceptor loginRequiredInterceptor;

    @Autowired
    private MessageInterceptor messageInterceptor;

    @Autowired
    private StatisticUsersInterceptor statisticUsersInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginTicketInterceptor)
                .addPathPatterns("/**");

        registry.addInterceptor(statisticUsersInterceptor)
                .addPathPatterns("/**");

        registry.addInterceptor(messageInterceptor)
                .addPathPatterns("/**");

        registry.addInterceptor(alphaInterceptor)
                .excludePathPatterns("/**/*.css","/**/*.js","/**/*.png","/**/*.jpg","/**/*.jpeg")
                .addPathPatterns("/register","/login");

//      registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/**");
    }
}
