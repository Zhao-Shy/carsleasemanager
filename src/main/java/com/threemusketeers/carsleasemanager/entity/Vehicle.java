package com.threemusketeers.carsleasemanager.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("vehicle")
@Data
public class Vehicle {
    private Integer id;

    private String vehicleLogo;

    private String vehicleNum;

    private Integer travelNum;

    private String vehicleImg;

    private String vehicleDetail;

    private Date contactBegin;

    private Date contactEnd;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private Integer delFlag;
}