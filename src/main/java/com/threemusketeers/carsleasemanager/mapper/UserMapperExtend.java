package com.threemusketeers.carsleasemanager.mapper;

import com.threemusketeers.carsleasemanager.entity.User;

public interface UserMapperExtend extends UserMapper {
    User login(User user);
}