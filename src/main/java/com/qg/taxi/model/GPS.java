package com.qg.taxi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/8/16
 * Time: 21:36
 * Description: 返回GPS数据实体类
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class GPS {
    /**
     * 经度
     */
    @NonNull private double lng;
    /**
     * 纬度
     */
    @NonNull private double lat;
    /**
     * 数量
     */
    private int count;
    /**
     * 时间代表
     */
    private int timeRepre;
}
