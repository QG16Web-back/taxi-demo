package com.qg.taxi.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;


/**
 * @author:Wilder Gao
 * @time:2018/3/27
 * @Discription：
 */
public class CountModel extends BaseRowModel {

    /**
     * B
     * 查询的表名
     */
    private String tableName;

    /**
     * geoHash字符串
     */
    @ExcelProperty(value = "geoHash", index = 3)
    private String geoHash;
    /**
     * 区域车总量
     */
    @ExcelProperty(value = {"count"}, index = 1)
    private int count;
    /**
     * 时间标记
     */
    @ExcelProperty(value = {"time"}, index = 2)
    private int timeRepre;


    public String getGeoHash() {
        return geoHash;
    }

    public void setGeoHash(String geoHash) {
        this.geoHash = geoHash;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTimeRepre() {
        return timeRepre;
    }

    public void setTimeRepre(int timeRepre) {
        this.timeRepre = timeRepre;
    }

    @Override
    public String toString() {
        return "CountModel{" +
                "geoHash='" + geoHash + '\'' +
                ", count=" + count +
                ", timeRepre=" + timeRepre +
                '}';
    }

}
