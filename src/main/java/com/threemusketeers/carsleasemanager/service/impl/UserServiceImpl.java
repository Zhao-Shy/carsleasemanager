package com.threemusketeers.carsleasemanager.service.impl;

import com.threemusketeers.carsleasemanager.mapper.UserMapper;
import com.threemusketeers.carsleasemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
}
