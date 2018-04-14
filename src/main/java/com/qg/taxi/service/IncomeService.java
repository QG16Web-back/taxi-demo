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
 * Date: 2018/3/27
 * No struggle, talent how to match the willfulness.
 * Description:
 */
@Service
@Scope("prototype")
public class IncomeService implements Callable<List<DriverInfo>> {
    private final GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql;

    @Autowired
    public IncomeService(GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql) {
        this.gpsMeterDataHisDaoSql = gpsMeterDataHisDaoSql;
    }

    private static AtomicInteger integer = new AtomicInteger(1);

    public static void setInteger(AtomicInteger integer) {
        IncomeService.integer = integer;
    }

    @Override
    public List<DriverInfo> call() {
        String newTable = "meter_data_his" + integer.getAndIncrement();
        List<DriverInfo> infoList = gpsMeterDataHisDaoSql.getIncome(newTable);

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
        System.out.println(newTable + gpsMeterDataHisDaoSql);
        return infoList;
    }
}
