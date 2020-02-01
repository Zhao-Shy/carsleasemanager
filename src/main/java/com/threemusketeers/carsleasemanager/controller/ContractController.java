package com.threemusketeers.carsleasemanager.controller;

import com.threemusketeers.carsleasemanager.entity.Contract;
import com.threemusketeers.carsleasemanager.http.RequestContract;
import com.threemusketeers.carsleasemanager.http.ResponseEntityBase;
import com.threemusketeers.carsleasemanager.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhaoshy
 * @License: (C) Copyright 2016-2999, xxx Corporation Limited.
 * @Contact: zsyfaith@163.com
 * @Date: 2020-01-21 16:29
 * @Version: 1.0
 * @Description: 合同相关
 */

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    ContractService contractService;

    @GetMapping("/show")
    public ResponseEntityBase<List<Contract>> showContract(@RequestParam Integer id) {
        List<Contract> contracts = contractService.showContract(id);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (contracts.size() != 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setData(contracts);
            return responseEntityBase;
        }
        return responseEntityBase.failed("该账号没有订单, 如有疑问请咨询管理员");
    }

    @PostMapping("/add")
    public ResponseEntityBase addContract(@RequestBody Contract contract) {
        // 判断该用户ID和车辆ID下有没有合同, 有就提示"已存在合同"不添加
        Integer userId = contract.getUserId();
        Integer vehicleId = contract.getVehicleId();
        Map<String, Integer> map = new HashMap<>();
        map.put("userId", userId);
        map.put("vehicleId", vehicleId);
        Contract existContract = contractService.existContract(map);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (existContract != null) {
            int i = contractService.addContract(contract);
            if (i > 0) {
                responseEntityBase.setCode(1);
                responseEntityBase.setMessage("添加成功");
                return responseEntityBase;
            }
            return responseEntityBase.failed("添加失败, 请重试");
        }
        return responseEntityBase.failed("已存在合同, 如有疑问请联系管理员");
    }

    @GetMapping("/del")
    public ResponseEntityBase delContract(@RequestParam Integer id) {
        int i = contractService.delContract(id);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (i >= 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("删除成功");
            return responseEntityBase;
        }
        return responseEntityBase.failed("删除失败, 请重试");
    }

    @PostMapping("/edit")
    public ResponseEntityBase editContract(@RequestBody Contract contract) {
        int i = contractService.editContract(contract);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (i >= 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("修改成功");
            return responseEntityBase;
        }
        return responseEntityBase.failed("修改失败, 请重试");
    }
}
