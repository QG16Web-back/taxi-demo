package com.qg.taxi.model;

import java.util.Date;

/**
 * Wilder Gao
 * Created by Administrator on 2018/3/24.
 */
public class GpsMeterDataHis {
    private long id;        //数据序号
    private String plateNo;     //车牌号码
    private String chauffeurNo;     //司机卡编号
    private Date workBeginTime;     //运营开始时间
    private Date workEndTime;       //运营结束时间
    private double price;       //运营结束单价
    private double loadMileage;     //载客里程公里
    private double meterMoney;      //本次计价金额
    private double emptyMileage;    //空载里程公里
    private Date emptyBeginTime;       //空车开始时间
    private String payMode;         //支付方式
    private int timeRepre;      // 时间代表，以小时为代表，后面需要以小时进行统计

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getChauffeurNo() {
        return chauffeurNo;
    }

    public void setChauffeurNo(String chauffeurNo) {
        this.chauffeurNo = chauffeurNo;
    }

    public Date getWorkBeginTime() {
        return workBeginTime;
    }

    public void setWorkBeginTime(Date workBeginTime) {
        this.workBeginTime = workBeginTime;
    }

    public Date getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Date workEndTime) {
        this.workEndTime = workEndTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLoadMileage() {
        return loadMileage;
    }

    public void setLoadMileage(double loadMileage) {
        this.loadMileage = loadMileage;
    }

    public double getMeterMoney() {
        return meterMoney;
    }

    public void setMeterMoney(double meterMoney) {
        this.meterMoney = meterMoney;
    }

    public double getEmptyMileage() {
        return emptyMileage;
    }

    public void setEmptyMileage(double emptyMileage) {
        this.emptyMileage = emptyMileage;
    }

    public Date getEmptyBeginTime() {
        return emptyBeginTime;
    }

    public void setEmptyBeginTime(Date emptyBeginTime) {
        this.emptyBeginTime = emptyBeginTime;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public int getTimeRepre() {
        return timeRepre;
    }

    public void setTimeRepre(int timeRepre) {
        this.timeRepre = timeRepre;
    }

    @Override
    public String toString() {
        return "GpsMeterDataHis{" +
                "id=" + id +
                ", plateNo='" + plateNo + '\'' +
                ", chauffeurNo='" + chauffeurNo + '\'' +
                ", workBeginTime=" + workBeginTime +
                ", workEndTime=" + workEndTime +
                ", price=" + price +
                ", loadMileage=" + loadMileage +
                ", meterMoney=" + meterMoney +
                ", emptyMileage=" + emptyMileage +
                ", emptyBeginTime=" + emptyBeginTime +
                ", payMode='" + payMode + '\'' +
                ", timeRepre=" + timeRepre +
                '}';
    }
}
