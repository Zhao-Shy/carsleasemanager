package com.threemusketeers.carsleasemanager.controller;

import com.threemusketeers.carsleasemanager.entity.Accident;
import com.threemusketeers.carsleasemanager.http.ResponseEntityBase;
import com.threemusketeers.carsleasemanager.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: zhaoshy
 * @License: (C) Copyright 2016-2999, xxx Corporation Limited.
 * @Contact: zsyfaith@163.com
 * @Date: 2020-01-21 16:24
 * @Version: 1.0
 * @Description: 事故记录相关
 */

@RestController
@RequestMapping("/accident")
public class AccidentController {
    @Autowired
    AccidentService accidentService;

    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public ResponseEntityBase addAccident(@RequestBody Accident accident) {
        int i = accidentService.addAccident(accident);
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
    public ResponseEntityBase updateAccident(@RequestBody Accident accident) {
        int i = accidentService.updateAccident(accident);
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
    public ResponseEntityBase deleteAccident(@RequestParam int id) {
        int i = accidentService.deleteAccident(id);
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
    public ResponseEntityBase accidentList(@RequestBody Accident accident) {
        List<Accident> list = accidentService.accidentList(accident);
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
    public ResponseEntityBase accidentDetail(@RequestParam int id) {
        Accident accident = accidentService.accidentDetail(id);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (accident != null) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("查询成功");
            responseEntityBase.setData(accident);
        }else{
            return responseEntityBase.failed("未查到数据");
        }
        return responseEntityBase;
    }
}
