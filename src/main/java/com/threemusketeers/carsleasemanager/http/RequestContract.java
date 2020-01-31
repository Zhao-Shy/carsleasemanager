package com.threemusketeers.carsleasemanager.http;

import com.threemusketeers.carsleasemanager.entity.Contract;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: zhaoshy
 * @License: (C) Copyright 2016-2999, xxx Corporation Limited.
 * @Contact: zsyfaith@163.com
 * @Date: 2020-01-31 21:16
 * @Version: 1.0
 * @Description:
 */

@Getter
@Setter
public class RequestContract {
    private int userId;
    private int vehicleId;
    private Contract contract;
}
