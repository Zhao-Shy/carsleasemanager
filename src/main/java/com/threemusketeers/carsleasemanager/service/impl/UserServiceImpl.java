package com.threemusketeers.carsleasemanager.service.impl;

import com.threemusketeers.carsleasemanager.entity.User;
import com.threemusketeers.carsleasemanager.mapper.UserMapper;
import com.threemusketeers.carsleasemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/1/18 0:12
 ****************************************
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(User user) {
        int i = userMapper.insertSelective(user);
        return i;
    }
}
