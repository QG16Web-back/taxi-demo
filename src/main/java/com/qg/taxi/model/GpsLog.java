package com.qg.taxi.model;

import java.util.Date;

/**
 * 出租车的轨迹
 * Created by FunriLy on 2017/7/29.
 * From small beginnings comes great things.
 */
public class GpsLog {

    private String licenseplateno;          //车牌号
    private Date in_date;                   //入库时间
    private Date gps_date;                  //GPS时间
    private String longitude;               //经度
    private String latitude;                //纬度
    private String height;                  //高度
    private String speed;                   //速度
    private String direction;               //方向
    private String eff;                     //是否有效 (1有效; 0无效)
    private String car_stat1;               //车辆状态 (1防盗 ; 2 防劫; 4空车 ; 5 重车; 6 点火; 7 熄火)
    private String car_stat2;               //未知

    public GpsLog() {
    }

    public String getLicenseplateno() {
        return licenseplateno;
    }

    public void setLicenseplateno(String licenseplateno) {
        this.licenseplateno = licenseplateno;
    }

    public Date getIn_date() {
        return in_date;
    }

    public void setIn_date(Date in_date) {
        this.in_date = in_date;
    }

    public Date getGps_date() {
        return gps_date;
    }

    public void setGps_date(Date gps_date) {
        this.gps_date = gps_date;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getEff() {
        return eff;
    }

    public void setEff(String eff) {
        this.eff = eff;
    }

    public String getCar_stat1() {
        return car_stat1;
    }

    public void setCar_stat1(String car_stat1) {
        this.car_stat1 = car_stat1;
    }

    public String getCar_stat2() {
        return car_stat2;
    }

    public void setCar_stat2(String car_stat2) {
        this.car_stat2 = car_stat2;
    }

    @Override
    public String toString() {
        return "GpsLog{" +
                "licenseplateno='" + licenseplateno + '\'' +
                ", in_date=" + in_date +
                ", gps_date=" + gps_date +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", height='" + height + '\'' +
                ", speed='" + speed + '\'' +
                ", direction='" + direction + '\'' +
                ", eff='" + eff + '\'' +
                ", car_stat1='" + car_stat1 + '\'' +
                ", car_stat2='" + car_stat2 + '\'' +
                '}';
    }
}
