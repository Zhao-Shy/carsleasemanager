package com.threemusketeers.carsleasemanager.mapper;

import com.threemusketeers.carsleasemanager.entity.Accident;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccidentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Accident record);

    int insertSelective(Accident record);

    Accident selectByPrimaryKey(Integer id);

    List<Accident> selectByAll(Accident record);

    int updateByPrimaryKeySelective(Accident record);

    int updateByPrimaryKey(Accident record);
}