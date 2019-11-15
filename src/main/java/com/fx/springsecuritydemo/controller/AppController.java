package com.fx.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther:
 * @date: 2019/11/15 13:54
 * @description:
 */
@Controller
public class AppController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello security";
    }
}
