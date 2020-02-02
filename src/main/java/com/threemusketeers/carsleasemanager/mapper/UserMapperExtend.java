package com.threemusketeers.carsleasemanager.mapper;

import com.threemusketeers.carsleasemanager.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapperExtend extends UserMapper {
    User login(User user);
    String selectUser(String username);
    List<User> getAllUser();
}
