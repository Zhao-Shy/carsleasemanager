package com.threemusketeers.carsleasemanager.service;

import com.threemusketeers.carsleasemanager.entity.Vehicle;
import java.util.List;
public interface VehicleService{
    //车辆签约
    int addVehicle(Vehicle vehicle);
    //车辆信息修改
    int updateVehicle(Vehicle vehicle);
    //车辆删除
    int deleteVehicle(int id);
    //管理员列表
    List<Vehicle> vehicleList();
    //车辆详情
    Vehicle vehicleDetail(int id);
}
