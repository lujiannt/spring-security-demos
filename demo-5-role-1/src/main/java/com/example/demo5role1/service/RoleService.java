package com.example.demo5role1.service;

import com.example.demo5role1.entity.Role;
import com.example.demo5role1.entity.Url;

import java.util.List;

public interface RoleService {
    /**
     * 根据用户id获取该用户角色
     *
     * @param userId
     * @return
     */
    List<Role> listRolesByUser(int userId);

    /**
     * 根据角色id获取可访问所有资源
     *
     * @param roleId
     * @return
     */
    List<Url> listUrlsByRole(int roleId);

    /**
     * 根据角色名查询角色
     *
     * @param roleName
     * @return
     */
    Role getRoleByName(String roleName);
}
