package com.qg.taxi.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/3/26
 * No struggle, talent how to match the willfulness.
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class ExcelPropertyIndexModel extends BaseRowModel {
    @ExcelProperty(value = "打车数量", index = 1)
    private String count;

    @ExcelProperty(value = "日期", index = 0)
    private String time;
}
