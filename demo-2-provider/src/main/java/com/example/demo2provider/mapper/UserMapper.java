package com.example.demo2provider.mapper;

import com.example.demo2provider.entity.Role;
import com.example.demo2provider.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User selectUserByName(String name);

    List<Role> selectRoleByUserId(int userId);
}
