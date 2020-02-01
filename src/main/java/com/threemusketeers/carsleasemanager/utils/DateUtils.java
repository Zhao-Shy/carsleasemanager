package com.threemusketeers.carsleasemanager.utils;

import java.util.Date;

/**
 * @Author: zhaoshy
 * @License: (C) Copyright 2016-2999, xxx Corporation Limited.
 * @Contact: zsyfaith@163.com
 * @Date: 2020-02-01 15:51
 * @Version: 1.0
 * @Description: 时间工具类
 */

public class DateUtils {
    public static long getDays(Date start, Date end) {
        long startTime = start.getTime();
        long endTime = end.getTime();
        long days = (long) ((endTime - startTime) / (1000 * 60 * 60 * 24));
        return days + 1L;
    }
}
