package com.wk.simplerpc.servlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * PackageName com.wk.simplerpc.servlet
 * Created by wangkang on 2017/11/28.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.wk.simplerpc.controller")
public class WebConfig  extends WebMvcConfigurerAdapter{
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("WEB-INF/views/");
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setExposeContextBeansAsAttributes(true);
        return resourceViewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
