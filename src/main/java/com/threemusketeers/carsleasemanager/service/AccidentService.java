package com.threemusketeers.carsleasemanager.service;

import com.threemusketeers.carsleasemanager.entity.Accident;

import java.util.List;

public interface AccidentService {
    //事故登记
    int addAccident(Accident accident);
    //事故信息维护
    int updateAccident(Accident accident);
    //事故消除
    int deleteAccident(int id);
    //管理员列表
    List<Accident> accidentList(Accident accident);
    //事故详情
    Accident accidentDetail(int id);
}
