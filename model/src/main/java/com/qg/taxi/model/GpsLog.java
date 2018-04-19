package com.qg.taxi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 出租车的轨迹
 * Created by FunriLy on 2017/7/29.
 * From small beginnings comes great things.
 */
@Data
@NoArgsConstructor
public class GpsLog {

    /**
     * 车牌号
     */
    private String licenseplateno;
    /**
     * 入库时间
     */
    private Date in_date;
    /**
     * GPS时间
     */
    private Date gps_date;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 高度
     */
    private String height;
    /**
     * 速度
     */
    private String speed;
    /**
     * 方向
     */
    private String direction;
    /**
     * 是否有效 (1有效; 0无效)
     */
    private String eff;
    /**
     * 车辆状态 (1防盗 ; 2 防劫; 4空车 ; 5 重车; 6 点火; 7 熄火)
     */
    private String car_stat1;
    /**
     * 未知
     */
    private String car_stat2;
}
