package com.threemusketeers.carsleasemanager.service;

import com.threemusketeers.carsleasemanager.entity.Accident;
import com.threemusketeers.carsleasemanager.entity.Maintain;

import java.util.List;

public interface MaintainService {
    //维修记录登记
    int addMaintain(Maintain maintain);
    //维修记录信息维护
    int updateMaintain(Maintain maintain);
    //维修记录消除
    int deleteMaintain(int id);
    //管理员列表
    List<Maintain> maintainList(Maintain maintain);
    //维修记录详情
    Maintain maintainDetail(int id);
}
