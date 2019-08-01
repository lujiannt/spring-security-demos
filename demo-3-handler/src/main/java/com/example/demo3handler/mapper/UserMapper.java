package com.example.demo3handler.mapper;

import com.example.demo3handler.entity.Role;
import com.example.demo3handler.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User selectUserByName(String name);

    List<Role> selectRoleByUserId(int userId);
}
