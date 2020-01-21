package com.threemusketeers.carsleasemanager.mapper;

import com.threemusketeers.carsleasemanager.entity.Accident;
import org.apache.ibatis.annotations.Select;

public interface AccidentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Accident record);

    int insertSelective(Accident record);

    Accident selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Accident record);

    int updateByPrimaryKey(Accident record);
}