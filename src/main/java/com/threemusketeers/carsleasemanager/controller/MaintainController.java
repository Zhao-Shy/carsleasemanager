package com.threemusketeers.carsleasemanager.controller;

import com.threemusketeers.carsleasemanager.entity.Accident;
import com.threemusketeers.carsleasemanager.entity.Maintain;
import com.threemusketeers.carsleasemanager.http.ResponseEntityBase;
import com.threemusketeers.carsleasemanager.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zhaoshy
 * @License: (C) Copyright 2016-2999, xxx Corporation Limited.
 * @Contact: zsyfaith@163.com
 * @Date: 2020-01-21 16:29
 * @Version: 1.0
 * @Description: 维修记录相关
 */

@RestController
@RequestMapping("/maintain")
public class MaintainController {
    @Autowired
    MaintainService maintainService;

    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public ResponseEntityBase addMaintain(@RequestBody Maintain maintain) {
        int i = maintainService.addMaintain(maintain);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (i > 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("登记成功");
        }else{
            return responseEntityBase.failed("登记失败");
        }
        responseEntityBase.setData("");
        return responseEntityBase;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntityBase updateMaintain(@RequestBody Maintain maintain) {
        int i = maintainService.updateMaintain(maintain);
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
    public ResponseEntityBase deleteMaintain(@RequestParam int id) {
        int i = maintainService.deleteMaintain(id);
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
    public ResponseEntityBase maintainList(@RequestBody Maintain Maintain) {
        List<Maintain> list = maintainService.maintainList(Maintain);
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
    public ResponseEntityBase maintainDetail(@RequestParam int id) {
        Maintain maintain = maintainService.maintainDetail(id);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (maintain != null) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("查询成功");
            responseEntityBase.setData(maintain);
        }else{
            return responseEntityBase.failed("未查到数据");
        }
        return responseEntityBase;
    }
}
