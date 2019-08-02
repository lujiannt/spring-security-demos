package com.example.demo6role2.controller;

import com.example.demo6role2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeleteController {
    @Autowired
    RoleService roleService;

    /**
     * 跳转到delete页面
     *
     * @return
     */
    @RequestMapping("/del")
    public String del() {
        return "/role/delete";
    }

    /**
     * 测试update接口权限
     *
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update() {
        String res = roleService.update();
        System.out.println("update result = " + res);
        return res;
    }

    /**
     * 测试delete接口权限
     *
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete() {
        String res = roleService.delete();
        System.out.println("delete result = " + res);
        return res;
    }
}
