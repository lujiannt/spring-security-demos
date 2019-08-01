package com.example.demo2provider.service;

import com.example.demo2provider.entity.MyUserPrincipal;
import com.example.demo2provider.entity.Role;
import com.example.demo2provider.entity.User;
import com.example.demo2provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userMapper.selectUserByName(userName);
        if(user == null) {
            throw new RuntimeException("user is null");
        }

        // 添加角色
        List<Role> roles = userMapper.selectRoleByUserId(user.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (int i = 0; i < roles.size(); i++) {
            authorities.add(new SimpleGrantedAuthority(roles.get(i).getRoleName()));
        }

        //方式一：使用自定义用户封装类
//        MyUserPrincipal myUser = new MyUserPrincipal(user, authorities);

        //方式二：使用springSecurity自己的User类
        org.springframework.security.core.userdetails.User myUser = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        return myUser;
    }
}
