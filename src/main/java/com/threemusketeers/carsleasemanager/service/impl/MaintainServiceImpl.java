package com.threemusketeers.carsleasemanager.service.impl;

import com.threemusketeers.carsleasemanager.entity.Accident;
import com.threemusketeers.carsleasemanager.entity.Maintain;
import com.threemusketeers.carsleasemanager.mapper.MaintainMapper;
import com.threemusketeers.carsleasemanager.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintainServiceImpl implements MaintainService {
    @Autowired
    MaintainMapper maintainMapper;

    /**
     * @Author: wuxiaojin
     * @Description: 维修记录登记
     * @return
     */
    @Override
    public int addMaintain(Maintain maintain){
        int i = maintainMapper.insertSelective(maintain);
        return i;
    }
    /**
     * @Author: wuxiaojin
     * @Description: 维修记录信息维护
     * @return
     */
    @Override
    public int updateMaintain(Maintain maintain){
        int i = maintainMapper.updateByPrimaryKeySelective(maintain);
        return i;
    }

    /**
     * @Author: wuxiaojin
     * @Description: 维修记录消除
     * @return
     */
    @Override
    public int deleteMaintain(int id){
        int i = maintainMapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * @Author: wuxiaojin
     * @Description: 管理员列表
     * @return
     */
    @Override
    public List<Maintain> maintainList(Maintain maintain){
        List<Maintain> list = maintainMapper.selectByAll(maintain);
        return list;
    }

    /**
     * @Author: wuxiaojin
     * @Description: 维修记录详情
     * @return
     */
    @Override
    public Maintain maintainDetail(int id){
        Maintain maintain = maintainMapper.selectByPrimaryKey(id);
        return maintain;
    }
}
