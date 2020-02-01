package com.threemusketeers.carsleasemanager.service.impl;

import com.threemusketeers.carsleasemanager.entity.Accident;
import com.threemusketeers.carsleasemanager.mapper.AccidentMapper;
import com.threemusketeers.carsleasemanager.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentServiceImpl implements AccidentService {

    @Autowired
    AccidentMapper accidentMapper;

    /**
     * @Author: wuxiaojin
     * @Description: 事故登记
     * @return
     */
    @Override
    public int addAccident(Accident accident){
        int i = accidentMapper.insertSelective(accident);
        return i;
    }
    /**
     * @Author: wuxiaojin
     * @Description: 事故登记信息维护
     * @return
     */
    @Override
    public int updateAccident(Accident accident){
        int i = accidentMapper.updateByPrimaryKeySelective(accident);
        return i;
    }

    /**
     * @Author: wuxiaojin
     * @Description: 事故信息消除
     * @return
     */
    @Override
    public int deleteAccident(int id){
        int i = accidentMapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * @Author: wuxiaojin
     * @Description: 管理员列表
     * @return
     */
    @Override
    public List<Accident> accidentList(Accident accident){
        List<Accident> list = accidentMapper.selectByAll(accident);
        return list;
    }

    /**
     * @Author: wuxiaojin
     * @Description: 事故详情
     * @return
     */
    @Override
    public Accident accidentDetail(int id){
        Accident accident = accidentMapper.selectByPrimaryKey(id);
        return accident;
    }
}
