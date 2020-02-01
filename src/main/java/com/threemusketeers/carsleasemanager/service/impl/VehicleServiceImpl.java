package com.threemusketeers.carsleasemanager.service.impl;

import com.threemusketeers.carsleasemanager.entity.Vehicle;
import com.threemusketeers.carsleasemanager.mapper.VehicleMapper;
import com.threemusketeers.carsleasemanager.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleMapper vehicleMapper;

    /**
     * @Author: wuxiaojin
     * @Description: 车辆签约
     * @return
     */
    @Override
    public int addVehicle(Vehicle vehicle){
        int i = vehicleMapper.insertSelective(vehicle);
        return i;
    }
    /**
     * @Author: wuxiaojin
     * @Description: 车辆信息维护
     * @return
     */
    @Override
    public int updateVehicle(Vehicle vehicle){
        int i = vehicleMapper.updateByPrimaryKeySelective(vehicle);
        return i;
    }

    /**
     * @Author: wuxiaojin
     * @Description: 车辆删除
     * @return
     */
    @Override
    public int deleteVehicle(int id){
        int i = vehicleMapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * @Author: wuxiaojin
     * @Description: 管理员列表
     * @return
     */
    @Override
    public List<Vehicle> vehicleList(){
        List<Vehicle> list = vehicleMapper.selectByAll();
        return list;
    }

    /**
     * @Author: wuxiaojin
     * @Description: 车辆详情
     * @return
     */
    @Override
    public Vehicle vehicleDetail(int id){
        Vehicle vehicle = vehicleMapper.selectByPrimaryKey(id);
        return vehicle;
    }
}
