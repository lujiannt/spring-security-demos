package com.example.demo4logout.mapper;

import com.example.demo4logout.entity.Role;
import com.example.demo4logout.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User selectUserByName(String name);

    List<Role> selectRoleByUserId(int userId);
}
