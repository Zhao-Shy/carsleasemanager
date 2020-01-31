package com.threemusketeers.carsleasemanager.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("contract")
@Data
public class Contract {
    private Integer id;

    private Long deposit;

    private Integer status;

    private Integer leaseType;

    private Date beginTime;

    private Date endTime;

    private Long beginOil;

    private Long endOil;

    private Long oilSpread;

    private Long maintainSpread;

    private Long overdueSpread;

    private Long amount;

    private Integer overdueTime;

    private Integer vehicleId;

    private Integer userId;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private Integer delFlag;

}