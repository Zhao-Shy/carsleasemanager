package com.threemusketeers.carsleasemanager.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Vehicle {
    private Integer id;

    private String vehicleLogo;

    private String vehicleNum;

    private Integer travelNum;

    private String vehicleImg;

    private String vehicleDetail;

    private Long vehicleRent;

    private Date contactBegin;

    private Date contactEnd;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private Integer delFlag;

}