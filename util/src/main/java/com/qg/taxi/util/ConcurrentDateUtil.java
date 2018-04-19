package com.qg.taxi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/3/30
 * No struggle, talent how to match the willfulness.
 * Description: 线程安全的时间格式转换工具类
 */
public class ConcurrentDateUtil {
    private static ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }
}
