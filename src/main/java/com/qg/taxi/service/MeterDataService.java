package com.qg.taxi.service;

import com.qg.taxi.dao.mysql.GPSMeterDataHisDaoSql;
import com.qg.taxi.model.TakeTaxiCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/3/26
 * No struggle, talent how to match the willfulness.
 * Description:
 */
@Service
public class MeterDataService implements Callable<List<TakeTaxiCount>> {

    private final
    GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql;

    @Autowired
    public MeterDataService(GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql) {
        this.gpsMeterDataHisDaoSql = gpsMeterDataHisDaoSql;
    }

    private static AtomicInteger integer = new AtomicInteger(1);

    public static void setInteger(AtomicInteger integer) {
        MeterDataService.integer = integer;
    }

    @Override
    public List<TakeTaxiCount> call() {

        String newTable = "meter_data_his" + integer.getAndIncrement();
        System.out.println(newTable);
        return gpsMeterDataHisDaoSql.totalCount(newTable);
    }
}
