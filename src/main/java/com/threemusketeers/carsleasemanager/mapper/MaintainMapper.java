package com.threemusketeers.carsleasemanager.mapper;

import com.threemusketeers.carsleasemanager.entity.Maintain;

import java.util.List;

public interface MaintainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Maintain record);

    int insertSelective(Maintain record);

    Maintain selectByPrimaryKey(Integer id);

    List<Maintain> selectByAll(Maintain maintain);

    int updateByPrimaryKeySelective(Maintain record);

    int updateByPrimaryKey(Maintain record);
}