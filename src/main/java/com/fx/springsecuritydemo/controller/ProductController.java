package com.fx.springsecuritydemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther: mabaofeng
 * @date: 2019/11/15 14:36
 * @description:
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/info")
    @ResponseBody
    public String product() {
        String currentUser = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principle = authentication.getPrincipal();
        if (principle instanceof UserDetails) {
            currentUser = ((UserDetails) principle).getUsername();

        } else {
            currentUser = principle.toString();
        }

        return "current loginuser:"+currentUser;
    }
}
