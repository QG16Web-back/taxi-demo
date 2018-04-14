package com.qg.taxi.model;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/8/16
 * Time: 21:36
 * Description: 返回GPS数据实体类
 */

public class GPS {
    private double lng;         // 经度
    private double lat;         // 纬度
    private int count;          //数量
    private int timeRepre;      //时间代表

    public GPS(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public GPS() {
    }

    ;

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTimeRepre() {
        return timeRepre;
    }

    public void setTimeRepre(int timeRepre) {
        this.timeRepre = timeRepre;
    }

    @Override
    public String toString() {
        return "GPS{" +
                "lng=" + lng +
                ", lat=" + lat +
                ", count=" + count +
                ", timeRepre=" + timeRepre +
                '}';
    }
}
