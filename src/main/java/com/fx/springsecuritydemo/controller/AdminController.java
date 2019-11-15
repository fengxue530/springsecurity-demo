package com.fx.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther:
 * @date: 2019/11/15 14:36
 * @description:
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/info")
    @ResponseBody
    public String admin(){
        return " admin info";
    }
}
