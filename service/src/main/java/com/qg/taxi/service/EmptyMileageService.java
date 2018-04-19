package com.qg.taxi.service;

import com.qg.taxi.dao.mysql.GPSMeterDataHisDaoSql;
import com.qg.taxi.model.DriverInfo;
import com.qg.taxi.util.SpringUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/3/29
 * No struggle, talent how to match the willfulness.
 * Description:
 */
@Service
public class EmptyMileageService implements Callable<List<DriverInfo>> {

    private static AtomicInteger integer = new AtomicInteger(1);

    public static void setInteger(AtomicInteger integer) {
        EmptyMileageService.integer = integer;
    }

    @Override
    public List<DriverInfo> call() {
        String newTable = "meter_data_his" + integer.getAndIncrement();
        // todo 利用 springUtil 工具类实现多例
        GPSMeterDataHisDaoSql mySql = SpringUtil.getBean(GPSMeterDataHisDaoSql.class);
        List<DriverInfo> infoList = mySql.getEmptyMileage(newTable);
        for (DriverInfo info : infoList) {
            if (Integer.parseInt(newTable.substring(14)) <= 9) {
                info.setDay("2017-02-0" + newTable.substring(14));
            } else if (Integer.parseInt(newTable.substring(14)) <= 28 && Integer.parseInt(newTable.substring(14)) >= 10) {
                info.setDay("2017-02-" + newTable.substring(14));
            } else if (Integer.parseInt(newTable.substring(14)) <= 37 && Integer.parseInt(newTable.substring(14)) >= 29) {
                info.setDay("2017-03-0" + (Integer.parseInt(newTable.substring(14)) - 28));
            } else {
                info.setDay("2017-03-" + (Integer.parseInt(newTable.substring(14)) - 28));
            }
        }
        System.out.println("查询" + newTable + " " + mySql);
        return infoList;
    }
}
