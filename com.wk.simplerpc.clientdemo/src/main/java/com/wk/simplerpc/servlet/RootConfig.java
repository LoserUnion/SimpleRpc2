package com.wk.simplerpc.servlet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * PackageName com.wk.simplerpc.servlet
 * Created by wangkang on 2017/11/28.
 */
@Configuration
@ComponentScan(basePackages = {"com.wk.simplerpc"},
                    excludeFilters = {@ComponentScan.Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {
}
