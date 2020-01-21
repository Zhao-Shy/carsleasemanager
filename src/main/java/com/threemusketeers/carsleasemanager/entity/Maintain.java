package com.threemusketeers.carsleasemanager.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("maintain")
@Data
public class Maintain {
    private Integer id;

    private String maintainDetail;

    private Date beginTime;

    private Date endTime;

    private Integer vehicleId;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;
}