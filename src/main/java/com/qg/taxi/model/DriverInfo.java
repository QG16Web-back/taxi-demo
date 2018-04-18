package com.qg.taxi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/3/29
 * No struggle, talent how to match the willfulness.
 * Description:
 */
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DriverInfo {
    /**
     * 车牌号
     */
    private String number;

    /**
     * 收入
     */
    private double income;

    /**
     * 空载里程
     */
    private double emptyMileage;

    /**
     * 日期
     */
    private String day;

    /**
     * 小时0-23
     */
    private int hour;

}
