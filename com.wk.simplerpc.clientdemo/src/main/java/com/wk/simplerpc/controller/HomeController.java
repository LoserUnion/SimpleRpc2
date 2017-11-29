package com.wk.simplerpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * PackageName com.wk.simplerpc.controller
 * Created by wangkang on 2017/11/29.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
