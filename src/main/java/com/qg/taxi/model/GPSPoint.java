package com.qg.taxi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 前端测试用的 GPS 点
 * Created by FunriLy on 2017/7/30.
 * From small beginnings comes great things.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GPSPoint {

    /**
     * 增加的属性，为了方便MySQL操作，已经设置添加时自动增加主键
     */
    private long id;
    /**
     * 车牌号
     */
    private String licenseplateno;
    /**
     * GPS时间
     */
    private Date gps_date;
    /**
     * 经度
     */
    private double longitude;
    /**
     * 纬度
     */
    private double latitude;
    /**
     * 速度
     */
    private int speed;
    /**
     * 方向
     */
    private String direction;
    /**
     * 车辆状态 (1防盗 ; 2 防劫; 4空车 ; 5 重车; 6 点火; 7 熄火)
     */
    private String car_stat1;

    /**
     * 构造器
     *
     * @param gpsLog
     */
    public GPSPoint(GpsLog gpsLog) {
        this.licenseplateno = gpsLog.getLicenseplateno();
        this.gps_date = gpsLog.getGps_date();
        this.longitude = Double.valueOf(gpsLog.getLongitude().replaceAll("\\+", "").replaceAll("-", ""));
        this.latitude = Double.valueOf(gpsLog.getLatitude().replaceAll("\\+", "").replaceAll("-", ""));
        this.speed = Integer.valueOf(gpsLog.getSpeed());
        this.direction = gpsLog.getDirection();
        this.car_stat1 = gpsLog.getCar_stat1();
    }
}
