package com.qg.taxi.model;

import com.qg.taxi.dao.mysql.GPSMeterDataHisDaoSql;
import com.qg.taxi.utils.RowKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018/4/12.
 */
public class UpdateCallable implements Callable<String> {
    private GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql;
    private String tableName;
    private CountDownLatch countDownLatch;

    @Autowired
    public UpdateCallable(String tableName, GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql,
                          CountDownLatch countDownLatch) {
        this.tableName = tableName;
        this.gpsMeterDataHisDaoSql = gpsMeterDataHisDaoSql;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String call() throws Exception {
        List<GpsOperateHis> operateHisList = gpsMeterDataHisDaoSql.getOpsHisData(this.tableName);
        System.out.println("==========" + tableName + "正在执行操作=========");
        for (GpsOperateHis gpsOperateHis : operateHisList) {

            String rowKey = RowKeyUtils.getRowKey(gpsOperateHis.getId(),
                    gpsOperateHis.getPlateNo(),
                    gpsOperateHis.getGeoHash(), gpsOperateHis.getWorkBeginTime());
            gpsOperateHis.setRowKey(rowKey);
            gpsMeterDataHisDaoSql.updateOpsHis(tableName, gpsOperateHis.getRowKey(),
                    gpsOperateHis.getId());
            System.out.println(tableName + "=======更新数据=======");
        }
        countDownLatch.countDown();
        return "success";
    }
}
