package com.qg.taxi.service;

import com.qg.taxi.dao.mysql.GPSMeterDataHisDaoSql;
import com.qg.taxi.model.CountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author:Wilder Gao
 * @time:2018/3/29
 * @Discription：
 */
public class CountDayCallable implements Callable<Map<String, List<CountModel>>> {
    private static int ZERO = 0;
    private static int TWENTY_FOUR = 24;
    private String tableName;
    private GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql;
    private CountDownLatch countDownLatch;


    @Autowired
    public CountDayCallable(String tableName, GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql, CountDownLatch countDownLatch) {
        this.tableName = tableName;
        this.gpsMeterDataHisDaoSql = gpsMeterDataHisDaoSql;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public Map<String, List<CountModel>> call() throws Exception {
        List<CountModel> collectList = new CopyOnWriteArrayList<>();

        for (int i = ZERO; i <= TWENTY_FOUR; i++) {
            List<CountModel> models = gpsMeterDataHisDaoSql.countByDay(tableName, i);
            if (models.size() == 0) {
                continue;
            } else {
                //要在内部统计完成之后才返回到主线程，循环的任务是将查询到的内容放到同一个集合中统计
                if (collectList.addAll(models) == false) {
                    System.out.println("<<<<<<<<<<<聚合失败>>>>>>>>>>>");
                }
            }
        }

        Map<String, List<CountModel>> sortByGeoHashMap = new ConcurrentHashMap<>();

        for (CountModel model : collectList) {
            if (sortByGeoHashMap.size() == 0 || !sortByGeoHashMap.containsKey(model.getGeoHash())) {
                List<CountModel> countModels = new ArrayList<>();
                countModels.add(model);
                sortByGeoHashMap.put(model.getGeoHash(), countModels);
            } else {
                List<CountModel> models = sortByGeoHashMap.get(model.getGeoHash());
                models.add(model);
                sortByGeoHashMap.replace(model.getGeoHash(), models);
            }
        }

        System.out.println("<<<<<<<<<<<<<<<<<<<<<" + this.tableName + "相应操作整理完毕>>>>>>>>>>>>>>>>>>>>>>>>>>");

        countDownLatch.countDown();
        return sortByGeoHashMap;
    }

}
