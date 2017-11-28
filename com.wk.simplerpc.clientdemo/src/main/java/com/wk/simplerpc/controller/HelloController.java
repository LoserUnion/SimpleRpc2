package com.wk.simplerpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PackageName com.wk.simplerpc.controller
 * Created by wangkang on 2017/11/27.
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public void hello(String name){
        System.out.println("into controller..");
    }
}
