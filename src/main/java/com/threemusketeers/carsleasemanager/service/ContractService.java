package com.threemusketeers.carsleasemanager.service;

import com.threemusketeers.carsleasemanager.entity.Contract;

import java.util.List;
import java.util.Map;

public interface ContractService {
    int addContract(Contract contract);
    int delContract(Integer id);
    int editContract(Contract contract);
    Contract existContract(Map<String, Integer> map);
    List<Contract> showContract(Integer id, Integer userType);
}
