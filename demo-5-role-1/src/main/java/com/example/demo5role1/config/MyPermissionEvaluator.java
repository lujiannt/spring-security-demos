package com.example.demo5role1.config;

import com.example.demo5role1.entity.Url;
import com.example.demo5role1.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Configuration
public class MyPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    private RoleService roleService;


    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        System.out.println("checking is has permission......");
        System.out.println("targetUrl is " + targetUrl);
        System.out.println("targetPermission is " + targetPermission);
        // 获得loadUserByUsername()方法的结果
        User user = (User) authentication.getPrincipal();
        // 获得loadUserByUsername()中注入的角色
        Collection<GrantedAuthority> authorities = user.getAuthorities();

        // 遍历用户所有角色
        for (GrantedAuthority authority : authorities) {
            String roleName = authority.getAuthority();
            Integer roleId = roleService.getRoleByName(roleName).getId();

            // 得到角色所有的url权限
            List<Url> urls = roleService.listUrlsByRole(roleId);

            // 遍历permissionList
            for (Url url : urls) {
                // 如果访问的Url和权限用户符合的话，返回true
                if (targetUrl.equals(url.getUrl())) {
                    return true;
                }
            }

        }

        return false;


    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
