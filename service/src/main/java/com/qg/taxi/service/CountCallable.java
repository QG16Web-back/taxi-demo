package com.qg.taxi.service;

import com.qg.taxi.dao.mysql.GPSMeterDataHisDaoSql;
import com.qg.taxi.model.CountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author:Wilder Gao
 * @time:2018/3/27
 * @Discription：
 */
public class CountCallable implements Callable<List<CountModel>> {
    private String tableName;
    private CountDownLatch countDownLatch;
    private String geoHash;
    private GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql;


    @Autowired
    public CountCallable(String tableName, CountDownLatch countDownLatch, String geoHash, GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql) {
        this.tableName = tableName;
        this.countDownLatch = countDownLatch;
        this.geoHash = geoHash;
        this.gpsMeterDataHisDaoSql = gpsMeterDataHisDaoSql;
    }


    @Override
    public List<CountModel> call() throws Exception {
        System.out.println(tableName + "开始执行");
        List<CountModel> models = gpsMeterDataHisDaoSql.countByTimeGeoHash(this.tableName, this.geoHash);
        System.out.println("<<<<<<表" + this.tableName + "查询完毕>>>>>>>");

        countDownLatch.countDown();
        return models;
    }

}
