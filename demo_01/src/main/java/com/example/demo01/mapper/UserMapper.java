package com.example.demo01.mapper;

import com.example.demo01.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository
public interface UserMapper {

    List<User> getAll();

    void save(User user);
}
