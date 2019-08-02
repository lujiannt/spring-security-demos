package com.example.demo6role2.mapper;

import com.example.demo6role2.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUserByName(String name);
}
