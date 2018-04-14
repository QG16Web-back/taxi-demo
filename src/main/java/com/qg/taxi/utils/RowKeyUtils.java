package com.qg.taxi.utils;

import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2018/4/12.
 */
public class RowKeyUtils {
    /**
     * 得到固定格式的rowKey
     *
     * @param plateNo
     * @param geoHash
     * @param date
     * @return
     */
    public static String getRowKey(long id, String plateNo, String geoHash, Date date) {
        Random random = new Random();
        Map<String, Integer> dateMap = DateUtil.getDayAndHour(date);
        plateNo = plateNo.replaceAll("粤", "");
        String month = dateMap.get("month") >= 10 ? dateMap.get("month").toString() :
                "0" + dateMap.get("month");
        String day = dateMap.get("day") >= 10 ? dateMap.get("day").toString() :
                "0" + dateMap.get("day");
        String hour = dateMap.get("hour") >= 10 ? dateMap.get("hour").toString() :
                "0" + dateMap.get("hour");
        String minute = dateMap.get("minute") >= 10 ? dateMap.get("minute").toString() :
                "0" + dateMap.get("minute");

        String rowKey = month + day
                + hour
                + minute
                + geoHash
                + plateNo
                + id;

        return rowKey;
    }
}
