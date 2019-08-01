package com.example.demo1basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    /**
     * 跳转到登录 【不需要权限】
     * @return
     */
    @RequestMapping("/openToLogin")
    public String openTologin() {
        return "/login";
    }

    /**
     * 跳转到首页 【需要权限】
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/index")
    public String index(String username, String password) {
        return "/index";
    }
}
