package com.threemusketeers.carsleasemanager.controller;

import com.threemusketeers.carsleasemanager.entity.User;
import com.threemusketeers.carsleasemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registered")
    public String addUser(@RequestParam(required = false) User user) {
        int i = userService.addUser(user);
        if (i > 0) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/login")
    public User login(@RequestParam(required = false) User user) {
        User login = userService.login(user);
        return login;
    }
}
