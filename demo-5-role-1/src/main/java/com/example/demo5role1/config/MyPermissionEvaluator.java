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

/**
 * 自定义权限过滤器
 */
@Configuration
public class MyPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    private RoleService roleService;

    /**
     * 通过请求过来的url和数据库中的角色对应url来对应校验权限
     *
     * @param authentication
     * @param targetUrl
     * @param targetPermission
     * @return
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        System.out.println("checking is has permission......");
        System.out.println("请求方法对应路径 : " + targetUrl);
        System.out.println("请求方法对应角色 ： " + targetPermission);
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
