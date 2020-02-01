package com.threemusketeers.carsleasemanager.mapper;

import com.threemusketeers.carsleasemanager.entity.Contract;
import com.threemusketeers.carsleasemanager.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ContractMapperExtend extends ContractMapper {
    List<Contract> showContract(Integer id, Integer userType);
    Contract existContract(Map<String, Integer> map);
    User selectUser(Integer id);
    Double getVehicleRent(Integer id);
}