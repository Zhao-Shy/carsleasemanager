package com.threemusketeers.carsleasemanager.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Accident {
    private Integer id;

    private String accidentDetail;

    private Date accidentTime;

    private Integer vehicleId;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

}