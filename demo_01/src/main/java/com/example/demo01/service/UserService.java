package com.example.demo01.service;

import com.example.demo01.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void save(User user);
}
