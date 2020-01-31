package com.threemusketeers.carsleasemanager.mapper;

import com.threemusketeers.carsleasemanager.entity.Contract;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContractMapperExtend extends ContractMapper {
    List<Contract> showContract(Integer id);
}