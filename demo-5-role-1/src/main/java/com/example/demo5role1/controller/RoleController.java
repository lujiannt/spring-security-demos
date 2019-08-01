package com.example.demo5role1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 权限测试controller
 */
@Controller
public class RoleController {
    /**
     * 跳转到role1页面
     *
     * @return
     */
    @RequestMapping("/role1")
    @PreAuthorize("hasPermission('/role1','ADMIN')")
    public String role1() {
        return "/role/role1";
    }

    /**
     * 跳转到role2页面
     *
     * @return
     */
    @RequestMapping("/role2")
    @PreAuthorize("hasPermission('/role2','USER')")
    public String role2() {
        return "/role/role2";
    }

    /**
     * 跳转到role3页面
     *
     * @return
     */
    @RequestMapping("/role3")
    public String role3() {
        return "/role/role3";
    }
}
