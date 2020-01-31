package com.threemusketeers.carsleasemanager.mapper;

import com.threemusketeers.carsleasemanager.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapperExtend extends UserMapper {
    User login(User user);
    String selectUser(String username);
}
