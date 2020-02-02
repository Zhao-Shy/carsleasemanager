package com.threemusketeers.carsleasemanager.controller;

import com.threemusketeers.carsleasemanager.entity.User;
import com.threemusketeers.carsleasemanager.http.ResponseEntityBase;
import com.threemusketeers.carsleasemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
        String s = userService.selectUser(user.getUsername());
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (StringUtils.isEmpty(s)) {
            int i = userService.addUser(user);
            if (i > 0) {
                responseEntityBase.setCode(1);
                responseEntityBase.setMessage("注册成功");
                return responseEntityBase;
            }
            return responseEntityBase.failed("注册失败");
        }
        return responseEntityBase.failed("用户已注册");
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

    @GetMapping("/show")
    public ResponseEntityBase showAllUser() {
        List<User> users = userService.getAllUser();
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (users.size() > 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setData(users);
            return responseEntityBase;
        }
        return responseEntityBase.failed("错误, 请重试或联系开发人员");
    }

    @GetMapping("/del")
    public ResponseEntityBase delUserById(@RequestParam Integer id) {
        int i = userService.delUserById(id);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (i > 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setData("删除成功");
            return responseEntityBase;
        }
        return responseEntityBase.failed("删除失败");
    }

    @PostMapping("/edit")
    public ResponseEntityBase editUser(@RequestBody User user) {
        int i = userService.editUser(user);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (i > 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setData("修改成功");
            return responseEntityBase;
        }
        return responseEntityBase.failed("修改失败");
    }
}
