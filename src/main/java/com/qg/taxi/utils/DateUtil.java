package com.qg.taxi.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/24.
 */
public class DateUtil {
    /**
     * 得到日期返回数值
     *
     * @param date
     * @return
     */
    public static Map<String, Integer> getDayAndHour(Date date) {
        Map<String, Integer> map = new HashMap<>();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);

        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();

        //如果大于二月份
        if (month == 3) {
            day = day + (month - 2) * 28;
        }
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();

        map.put("month", month);
        map.put("day", day);
        map.put("hour", hour);
        map.put("year", year);
        map.put("minute", minute);

        return map;
    }

    /**
     * 获得当天的前三天日期
     *
     * @param date
     * @return
     */
    public static int[] getDayBeforeThree(Date date) {
        int num = 4;
        int[] days = new int[num];
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        for (int i = 1; i <= num; i++) {
            LocalDateTime dateTime = localDateTime.minusDays(i);
            int month = dateTime.getMonthValue();
            int day = dateTime.getDayOfMonth();
            //假如是3月份，日期加上28和数据库表对应
            if (month == 3) {
                day += 28;
            }
            days[i - 1] = day;
        }
        return days;
    }
}
