package com.qg.taxi.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/3/29
 * No struggle, talent how to match the willfulness.
 * Description:
 */
public class EmptyMileageModel extends BaseRowModel {
    @ExcelProperty(value = "车牌号", index = 0)
    private String plateno;

    @ExcelProperty(value = "日期", index = 1)
    private String day;

    @ExcelProperty(value = "空载里程", index = 2)
    private String emptyMileage;

    public EmptyMileageModel() {
    }

    public EmptyMileageModel(String plateno, String day, String emptyMileage) {

        this.plateno = plateno;
        this.day = day;
        this.emptyMileage = emptyMileage;
    }

    public String getPlateno() {
        return plateno;
    }

    public void setPlateno(String plateno) {
        this.plateno = plateno;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getEmptyMileage() {
        return emptyMileage;
    }

    public void setEmptyMileage(String emptyMileage) {
        this.emptyMileage = emptyMileage;
    }
}
