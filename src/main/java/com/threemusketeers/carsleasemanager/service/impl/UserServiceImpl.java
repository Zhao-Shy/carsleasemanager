package com.threemusketeers.carsleasemanager.service.impl;

import com.threemusketeers.carsleasemanager.entity.User;
import com.threemusketeers.carsleasemanager.mapper.UserMapper;
import com.threemusketeers.carsleasemanager.mapper.UserMapperExtend;
import com.threemusketeers.carsleasemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserMapperExtend userMapperExtend;

    /**
     * @Author : zhaoshy
     * @Date : 2020-01-28 22:01
     * @Description : 用户注册
     */
    @Override
    public int addUser(User user) {
        int i = userMapper.insertSelective(user);
        return i;
    }

    /**
     * @Author : zhaoshy
     * @Date : 2020-01-28 22:01
     * @Description : 用户登录
     */
    @Override
    public User login(User user) {
        User login = userMapperExtend.login(user);
        return login;
    }
}
