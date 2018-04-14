package com.qg.taxi.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/3/27
 * No struggle, talent how to match the willfulness.
 * Description:
 */
public class IncomeModel extends BaseRowModel {
    @ExcelProperty(value = "车牌号", index = 0)
    private String plateno;

    @ExcelProperty(value = "日期", index = 1)
    private String day;

    @ExcelProperty(value = "收入", index = 2)
    private String income;

    public IncomeModel(String plateno, String day, String income) {
        this.plateno = plateno;
        this.day = day;
        this.income = income;
    }

    public IncomeModel() {
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

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
