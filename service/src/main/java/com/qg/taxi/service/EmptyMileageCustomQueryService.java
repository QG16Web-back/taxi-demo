package com.qg.taxi.service;

import com.qg.taxi.dao.mysql.GPSMeterDataHisDaoSql;
import com.qg.taxi.model.DriverInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/4/6
 * No struggle, talent how to match the willfulness.
 * Description:
 */
@Service
@Scope("prototype")
public class EmptyMileageCustomQueryService implements Callable<List<DriverInfo>> {

    private final GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql;

    private int startTime;
    private int endTime;

    @Autowired
    public EmptyMileageCustomQueryService(GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql) {
        this.gpsMeterDataHisDaoSql = gpsMeterDataHisDaoSql;
    }

    private static AtomicInteger integer = new AtomicInteger(1);

    public static void setInteger(AtomicInteger integer) {
        EmptyMileageCustomQueryService.integer = integer;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public List<DriverInfo> call() {
        String table = "meter_data_his" + integer.getAndIncrement();
        List<DriverInfo> infoList = gpsMeterDataHisDaoSql.getEmptyMileageByCustomQuery(table, startTime, endTime);

        for (DriverInfo info : infoList) {
            if (Integer.parseInt(table.substring(14)) <= 9) {
                info.setDay("2017-02-0" + table.substring(14));
            } else if (Integer.parseInt(table.substring(14)) <= 28 && Integer.parseInt(table.substring(14)) >= 10) {
                info.setDay("2017-02-" + table.substring(14));
            } else if (Integer.parseInt(table.substring(14)) <= 37 && Integer.parseInt(table.substring(14)) >= 29) {
                info.setDay("2017-03-0" + (Integer.parseInt(table.substring(14)) - 28));
            } else {
                info.setDay("2017-03-" + (Integer.parseInt(table.substring(14)) - 28));
            }
        }
        System.out.println(table + gpsMeterDataHisDaoSql);
        return infoList;
    }
}
