package com.example.demo5role1.mapper;

import com.example.demo5role1.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUserByName(String name);
}
