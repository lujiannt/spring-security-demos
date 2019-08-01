package com.example.demo3handler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/openToLogin")
    public String openTologin() {
        return "/login";
    }

    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "/dashboard";
    }
}
