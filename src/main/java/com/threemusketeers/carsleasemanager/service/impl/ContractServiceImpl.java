package com.threemusketeers.carsleasemanager.service.impl;

import com.threemusketeers.carsleasemanager.entity.Contract;
import com.threemusketeers.carsleasemanager.mapper.ContractMapper;
import com.threemusketeers.carsleasemanager.mapper.ContractMapperExtend;
import com.threemusketeers.carsleasemanager.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractMapper contractMapper;

    @Autowired
    ContractMapperExtend contractMapperExtend;

    @Override
    public int addContract(Contract contract) {
        int i = contractMapper.insertSelective(contract);
        return i;
    }

    @Override
    public int delContract(Integer id) {
        int i = contractMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int editContract(Contract contract) {
        int i = contractMapper.updateByPrimaryKeySelective(contract);
        return i;
    }

    @Override
    public List<Contract> showContract(Integer id) {
        List<Contract> contract = contractMapperExtend.showContract(id);
        return contract;
    }
}
