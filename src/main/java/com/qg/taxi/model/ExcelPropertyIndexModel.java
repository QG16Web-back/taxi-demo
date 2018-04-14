package com.qg.taxi.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/3/26
 * No struggle, talent how to match the willfulness.
 * Description:
 */
public class ExcelPropertyIndexModel extends BaseRowModel {
    @ExcelProperty(value = "打车数量", index = 1)
    private String count;

    @ExcelProperty(value = "日期", index = 0)
    private String time;

    public ExcelPropertyIndexModel(String count, String time) {
        this.count = count;
        this.time = time;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
