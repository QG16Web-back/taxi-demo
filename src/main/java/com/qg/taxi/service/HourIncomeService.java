package com.qg.taxi.service;

import com.qg.taxi.dao.mysql.GPSMeterDataHisDaoSql;
import com.qg.taxi.model.DriverInfo;
import com.qg.taxi.utils.SpringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author 小铭
 * Date: 2018/3/30
 * No struggle, talent how to match the willfulness.
 * Description:
 */
@Service
@Scope("prototype")
public class HourIncomeService implements Callable<List<DriverInfo>> {

    private String table;

    public void setTable(String table) {
        this.table = table;
    }

    @Override
    public List<DriverInfo> call() {
        GPSMeterDataHisDaoSql mySql = SpringUtil.getBean(GPSMeterDataHisDaoSql.class);
        System.out.println(table);
        return mySql.getIncomeByHour(table);
    }
}
