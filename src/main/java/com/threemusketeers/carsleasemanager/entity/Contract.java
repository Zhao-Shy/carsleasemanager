package com.threemusketeers.carsleasemanager.entity;

import java.util.Date;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(Integer leaseType) {
        this.leaseType = leaseType;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getBeginOil() {
        return beginOil;
    }

    public void setBeginOil(Long beginOil) {
        this.beginOil = beginOil;
    }

    public Long getEndOil() {
        return endOil;
    }

    public void setEndOil(Long endOil) {
        this.endOil = endOil;
    }

    public Long getOilSpread() {
        return oilSpread;
    }

    public void setOilSpread(Long oilSpread) {
        this.oilSpread = oilSpread;
    }

    public Long getMaintainSpread() {
        return maintainSpread;
    }

    public void setMaintainSpread(Long maintainSpread) {
        this.maintainSpread = maintainSpread;
    }

    public Long getOverdueSpread() {
        return overdueSpread;
    }

    public void setOverdueSpread(Long overdueSpread) {
        this.overdueSpread = overdueSpread;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(Integer overdueTime) {
        this.overdueTime = overdueTime;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}