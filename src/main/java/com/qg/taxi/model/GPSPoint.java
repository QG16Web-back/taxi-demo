package com.qg.taxi.model;

import java.util.Date;

/**
 * 前端测试用的 GPS 点
 * Created by FunriLy on 2017/7/30.
 * From small beginnings comes great things.
 */
public class GPSPoint {

    private long id;                        //增加的属性，为了方便MySQL操作，已经设置添加时自动增加主键
    private String licenseplateno;          //车牌号
    private Date gps_date;                  //GPS时间
    private double longitude;               //经度
    private double latitude;                //纬度
    private int speed;                   //速度
    private String direction;               //方向
    private String car_stat1;               //车辆状态 (1防盗 ; 2 防劫; 4空车 ; 5 重车; 6 点火; 7 熄火)

    public GPSPoint() {
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicenseplateno() {
        return licenseplateno;
    }

    public void setLicenseplateno(String licenseplateno) {
        this.licenseplateno = licenseplateno;
    }

    public Date getGps_date() {
        return gps_date;
    }

    public void setGps_date(Date gps_date) {
        this.gps_date = gps_date;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCar_stat1() {
        return car_stat1;
    }

    public void setCar_stat1(String car_stat1) {
        this.car_stat1 = car_stat1;
    }

    @Override
    public String toString() {
        return "GPSPoint{" +
                "id=" + id +
                ", licenseplateno='" + licenseplateno + '\'' +
                ", gps_date=" + gps_date +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", speed='" + speed + '\'' +
                ", direction='" + direction + '\'' +
                ", car_stat1='" + car_stat1 + '\'' +
                '}';
    }
}
