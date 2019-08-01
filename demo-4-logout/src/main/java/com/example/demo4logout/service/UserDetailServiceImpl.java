package com.example.demo4logout.service;

import com.example.demo4logout.entity.Role;
import com.example.demo4logout.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
        com.example.demo4logout.entity.User user = userMapper.selectUserByName(userName);
        if (user == null) {
            throw new RuntimeException("user is null");
        }

        // 添加角色
        List<Role> roles = userMapper.selectRoleByUserId(user.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (int i = 0; i < roles.size(); i++) {
            authorities.add(new SimpleGrantedAuthority(roles.get(i).getRoleName()));
        }

        User myUser = new User(user.getUsername(), user.getPassword(), authorities);
        return myUser;
    }
}
