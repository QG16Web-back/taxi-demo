package com.qg.taxi.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * @author:Wilder Gao
 * @time:2018/3/27
 * @Discription：
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class CountModel extends BaseRowModel {

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
}
