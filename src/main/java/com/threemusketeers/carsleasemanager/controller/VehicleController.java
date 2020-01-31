package com.threemusketeers.carsleasemanager.controller;

import com.threemusketeers.carsleasemanager.entity.Vehicle;
import com.threemusketeers.carsleasemanager.http.ResponseEntityBase;
import com.threemusketeers.carsleasemanager.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @Author: zhaoshy
 * @License: (C) Copyright 2016-2999, xxx Corporation Limited.
 * @Contact: zsyfaith@163.com
 * @Date: 2020-01-21 16:30
 * @Version: 1.0
 * @Description: 车辆管理
 */

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public ResponseEntityBase addVehicle(@RequestBody Vehicle vehicle) {
        Date date = new Date();
        int i = vehicleService.addVehicle(vehicle);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (i > 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("签约成功");
        }else{
            return responseEntityBase.failed("签约失败");
        }
        responseEntityBase.setData("");
        return responseEntityBase;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntityBase updateVehicle(@RequestBody Vehicle vehicle) {
        Date date = new Date();
        int i = vehicleService.updateVehicle(vehicle);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (i > 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("维护成功");
        }else{
            return responseEntityBase.failed("维护失败");
        }
        responseEntityBase.setData("");
        return responseEntityBase;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseEntityBase updateVehicle(@RequestParam int id) {
        Date date = new Date();
        int i = vehicleService.deleteVehicle(id);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (i > 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("删除成功");
        }else{
            return responseEntityBase.failed("删除失败");
        }
        responseEntityBase.setData("");
        return responseEntityBase;
    }

    @RequestMapping(value = "/list")
    public ResponseEntityBase vehicleList() {
        List<Vehicle> list = vehicleService.vehicleList();
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (list.size() > 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("查询成功");
            responseEntityBase.setData(list);
        }else{
            return responseEntityBase.failed("未查到数据");
        }
        return responseEntityBase;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseEntityBase vehicleDetail(@RequestParam int id) {
       Vehicle vehicle = vehicleService.vehicleDetail(id);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (vehicle != null) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("查询成功");
            responseEntityBase.setData(vehicle);
        }else{
            return responseEntityBase.failed("未查到数据");
        }
        return responseEntityBase;
    }
}
