package com.example.demo01.service.impl;

import com.example.demo01.mapper.UserMapper;
import com.example.demo01.pojo.User;
import com.example.demo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }
}
