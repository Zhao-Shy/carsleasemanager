package com.threemusketeers.carsleasemanager.controller;

import com.threemusketeers.carsleasemanager.entity.User;
import com.threemusketeers.carsleasemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        int i = userService.addUser(user);
        if (i > 0) {
            return "success";
        }
        return "failed";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody User user) {
        User login = userService.login(user);
        return login;
    }
}
