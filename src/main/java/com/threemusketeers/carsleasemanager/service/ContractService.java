package com.threemusketeers.carsleasemanager.service;

import com.threemusketeers.carsleasemanager.entity.Contract;

import java.util.List;

public interface ContractService {
    int addContract(Contract contract);
    int delContract(Integer id);
    int editContract(Contract contract);
    List<Contract> showContract(Integer id);
}
