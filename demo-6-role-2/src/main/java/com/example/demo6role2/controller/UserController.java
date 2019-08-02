package com.example.demo6role2.controller;

import com.example.demo6role2.Utils.LoginUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class UserController {
    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/openToLogin")
    public String openTologin() {
        return "/login";
    }

    /**
     * 跳转到登出页面
     *
     * @return
     */
    @RequestMapping("/out")
    public String out() {
        return "/logout";
    }

    /**
     * 跳转到index页面
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    /**
     * 跳转到dashboard页面
     *
     * @return
     */
    @RequestMapping("/dashboard")
    public String dashboard() {
        return "/dashboard";
    }

    /**
     * 获取用户信息
     * 【controller获取方式一】 Principal获取
     *
     * @return
     */
    @RequestMapping("/userName1")
    @ResponseBody
    public String getUserInfo1(Principal principal) {
        return principal.getName();
    }

    /**
     * 获取用户信息
     * 【controller获取方式二】 authentication获取
     *
     * @return
     */
    @RequestMapping("/userName2")
    @ResponseBody
    public String getUserInfo2(Authentication authentication) {
        return authentication.getName();
    }

    /**
     * 获取用户信息
     * 【controller获取方式三】 在util中根据security获取
     *
     * @return
     */
    @RequestMapping("/userName3")
    @ResponseBody
    public String getUserInfo3() {
        String uname = LoginUtils.getLoginUser().getUsername();
        System.out.println("uname is " + uname);
        return uname;
    }
}
