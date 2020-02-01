package com.threemusketeers.carsleasemanager.service.impl;

import com.threemusketeers.carsleasemanager.entity.Contract;
import com.threemusketeers.carsleasemanager.entity.User;
import com.threemusketeers.carsleasemanager.mapper.ContractMapper;
import com.threemusketeers.carsleasemanager.mapper.ContractMapperExtend;
import com.threemusketeers.carsleasemanager.service.ContractService;
import com.threemusketeers.carsleasemanager.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractMapper contractMapper;

    @Autowired
    ContractMapperExtend contractMapperExtend;

    @Override
    public int addContract(Contract contract) {
        // 判断该用户是否是会员, 不是就按照普通租金, 是就根据会员等级计算折扣, 普通会员9折, 高级会员8折
        User user = contractMapperExtend.selectUser(contract.getUserId());
        // 获取该车辆租金
        Double vehicleRent = contractMapperExtend.getVehicleRent(contract.getVehicleId());
        // 计算租赁时间
        Date beginTime = contract.getBeginTime();
        Date endTime = contract.getEndTime();
        long days = DateUtils.getDays(beginTime, endTime);

        // 计算租金
        long rent = vehicleRent.longValue() * days;

        if (user.getUserType() == 0) {
            contract.setAmount(rent);
            int i = contractMapper.insertSelective(contract);
            return i;
        } else {
            if (user.getMemberType() == 0) {
                contract.setAmount((long) (rent * 0.9));
                int i = contractMapper.insertSelective(contract);
                return i;
            } else {
                contract.setAmount((long) (rent * 0.8));
                int i = contractMapper.insertSelective(contract);
                return i;
            }
        }
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

    /**
     * @Author : zhaoshy
     * @Date : 2020-02-01 14:51
     * @Description : 判断是否存在合同
     */
    @Override
    public Contract existContract(Map<String, Integer> map) {
        Contract contract = contractMapperExtend.existContract(map);
        return contract;
    }

    @Override
    public List<Contract> showContract(Integer id, Integer userType) {
        List<Contract> contract = contractMapperExtend.showContract(id, userType);
        return contract;
    }
}
