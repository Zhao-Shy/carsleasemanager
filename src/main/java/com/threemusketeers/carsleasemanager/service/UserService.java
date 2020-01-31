package com.threemusketeers.carsleasemanager.service;

import com.threemusketeers.carsleasemanager.entity.User;

public interface UserService {
    int addUser(User user);
    User login(User user);
    String selectUser(String username);
}
