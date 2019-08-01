package com.example.demo5role1.serviceImpl;

import com.example.demo5role1.entity.Role;
import com.example.demo5role1.entity.Url;
import com.example.demo5role1.mapper.RoleMapper;
import com.example.demo5role1.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> listRolesByUser(int userId) {
        return roleMapper.selectRoleByUserId(userId);
    }

    @Override
    public List<Url> listUrlsByRole(int roleId) {
        return roleMapper.selectUrlByRoleId(roleId);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleMapper.selectRoleByName(roleName);
    }
}
