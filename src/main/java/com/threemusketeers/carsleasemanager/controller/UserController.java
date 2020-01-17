package com.threemusketeers.carsleasemanager.controller;

import com.threemusketeers.carsleasemanager.entity.User;
import com.threemusketeers.carsleasemanager.mapper.UserMapper;
import com.threemusketeers.carsleasemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/1/17 23:40
 ****************************************
 */

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public String getUser(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        int i = userService.addUser(user);
        if (i > 0) {
            return "success";
        }
        return "default";
    }
}
