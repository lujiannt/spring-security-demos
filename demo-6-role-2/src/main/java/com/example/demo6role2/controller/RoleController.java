package com.example.demo6role2.controller;

import com.example.demo6role2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 权限测试controller
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;


    /**
     * 跳转到自定义权限403页面
     *
     * @return
     */
    @RequestMapping("/forbidden")
    public String forbidden() {
        return "/role/forbidden";
    }

    /*------------------------------------------ hasPermission注意点 ------------------------------------------*/
    //1.这里判断的是请求的url 和 用户对应角色在数据库中的url 对比（具体逻辑在evaluator中）
    //2.这里hasPermission中的角色其实没起到作用

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

    /*------------------------------------------ hasRole注意点 ------------------------------------------*/
    //1.使用hasRole时，数据库中要加ROLE_前缀

    /**
     * 跳转到role3页面
     *
     * @return
     */
    @RequestMapping("/role3")
    @PreAuthorize("hasRole('ADMIN')")
    public String role3() {
        return "/role/role3";
    }

    /**
     * 跳转到role4页面
     *
     * @return
     */
    @RequestMapping("/role4")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String role4() {
        return "/role/role4";
    }

    /*------------------------------------------ hasAuthority注意点 ------------------------------------------*/
    //1.使用hasAuthority时，数据库中不需要加任何前缀，只需要和代码中角色对应即可

    /**
     * 跳转到role5页面
     *
     * @return
     */
    @RequestMapping("/role5")
    @PreAuthorize("hasAuthority('ADMIN1')")
    public String role5() {
        return "/role/role5";
    }

    /**
     * 跳转到role6页面
     *
     * @return
     */
    @RequestMapping("/role6")
    @PreAuthorize("hasAuthority('USER1')")
    public String role6() {
        return "/role/role6";
    }
}
