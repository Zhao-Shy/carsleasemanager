package com.threemusketeers.carsleasemanager.controller;

import com.threemusketeers.carsleasemanager.entity.User;
import com.threemusketeers.carsleasemanager.http.ResponseEntityBase;
import com.threemusketeers.carsleasemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhaoshy
 * @License: (C) Copyright 2016-2999, xxx Corporation Limited.
 * @Contact: zsyfaith@163.com
 * @Date: 2020-01-21 16:30
 * @Version: 1.0
 * @Description: 用户相关
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public ResponseEntityBase addUser(@RequestBody User user) {
        int i = userService.addUser(user);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (i > 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("注册成功");
            return responseEntityBase;
        }
        return responseEntityBase.failed("注册失败");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntityBase login(@RequestBody User user) {
        User login = userService.login(user);
        Map<String, User> map = new HashMap<>();
        map.put("user", login);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (login != null) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("登录成功");
            responseEntityBase.setData(map);
            return responseEntityBase;
        }
        return responseEntityBase.failed("账户或密码错误, 请重试");
    }
}
