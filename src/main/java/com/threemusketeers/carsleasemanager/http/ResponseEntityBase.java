package com.threemusketeers.carsleasemanager.http;

/**
 * @Author: zhaoshy
 * @License: (C) Copyright 2016-2999, xxx Corporation Limited.
 * @Contact: zsyfaith@163.com
 * @Date: 2020-01-31 14:44
 * @Version: 1.0
 * @Description: 返回值
 */

public class ResponseEntityBase<T> {
    // 1: 成功 0: 失败
    private int code = 1;
    private String message = "success";
    private T data;

    public ResponseEntityBase() {
    }

    public ResponseEntityBase(T data) {
        this.data = data;
    }

    public ResponseEntityBase(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseEntityBase(int code, String message){
        this.code = code;
        this.message = message;
    }

    public ResponseEntityBase(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseEntityBase getInstance() {
        return new ResponseEntityBase();
    }

    public ResponseEntityBase<T> success() {
        return new ResponseEntityBase(1, message);
    }

    public ResponseEntityBase<T> success(T data) {
        return new ResponseEntityBase(1, message, data);
    }

    public ResponseEntityBase<T> failed(String message) {
        return new ResponseEntityBase(0, message);
    }

    public ResponseEntityBase<T> failed(String message,T data) {
        return new ResponseEntityBase(0, message, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
