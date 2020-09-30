package com.example.demo01.controller;

import com.example.demo01.pojo.User;
import com.example.demo01.service.UserService;
import com.example.demo01.util.HttpClientDownPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getAllUser")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("getHtml")
    public String getHtml(
            @RequestParam("url") String url
    ) {
        return HttpClientDownPage.sendGet(url);
    }

    @PostMapping("save")
    public User save(
            User user
    ) {
        userService.save(user);
        return user;
    }
}
