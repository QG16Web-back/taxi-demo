package com.qg.taxi.model;

import java.util.Date;

/**
 * 运营记录历史数据，根据表2创建的实体类
 * Created by Wilder Gao on 2018/3/25.
 */
public class GpsOperateHis {
    private long id;
    private String equipmentId;     //设备Id
    private String plateNo;         //车牌号
    private long companyId;     //公司Id
    private String chauffeurNo;     //司机卡编号
    private String teamCode;        //车队代码
    private double emptyMile;     //空车里程
    private Date emptyBeginTime;    //空车开始时间
    private Date workBeginTime;     //运营开始时间
    private Date workEndTime;       //运营结束时间
    private double unitPrice;      //运营单价
    private double loadMile;        //运营里程
    private int slowCountTime;      //慢速计时
    private double operateMoney;    //运营金额
    private int evaluate;   //评价。0未评价，1非常满意，2满意，3不满意
    private String tradeCode;       //交易标识码
    private double getOnLongitude;      //上车经度
    private double getOnLatitude;    //上车纬度
    private double getOffLongitude;     //下车经度
    private double getOffLatitude;      //下车纬度
    private String geoHash;         //根据经纬度生成geoHash
    private int timeRepre;          //时间代表
    private String rowKey;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getChauffeurNo() {
        return chauffeurNo;
    }

    public void setChauffeurNo(String chauffeurNo) {
        this.chauffeurNo = chauffeurNo;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public double getEmptyMile() {
        return emptyMile;
    }

    public void setEmptyMile(double emptyMile) {
        this.emptyMile = emptyMile;
    }

    public Date getEmptyBeginTime() {
        return emptyBeginTime;
    }

    public void setEmptyBeginTime(Date emptyBeginTime) {
        this.emptyBeginTime = emptyBeginTime;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getLoadMile() {
        return loadMile;
    }

    public void setLoadMile(double loadMile) {
        this.loadMile = loadMile;
    }

    public int getSlowCountTime() {
        return slowCountTime;
    }

    public void setSlowCountTime(int slowCountTime) {
        this.slowCountTime = slowCountTime;
    }

    public double getOperateMoney() {
        return operateMoney;
    }

    public void setOperateMoney(double operateMoney) {
        this.operateMoney = operateMoney;
    }

    public int getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(int evaluate) {
        this.evaluate = evaluate;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public double getGetOnLongitude() {
        return getOnLongitude;
    }

    public void setGetOnLongitude(double getOnLongitude) {
        this.getOnLongitude = getOnLongitude;
    }

    public double getGetOnLatitude() {
        return getOnLatitude;
    }

    public void setGetOnLatitude(double getOnLatitude) {
        this.getOnLatitude = getOnLatitude;
    }

    public double getGetOffLongitude() {
        return getOffLongitude;
    }

    public void setGetOffLongitude(double getOffLongitude) {
        this.getOffLongitude = getOffLongitude;
    }

    public double getGetOffLatitude() {
        return getOffLatitude;
    }

    public void setGetOffLatitude(double getOffLatitude) {
        this.getOffLatitude = getOffLatitude;
    }

    public String getGeoHash() {
        return geoHash;
    }

    public void setGeoHash(String geoHash) {
        this.geoHash = geoHash;
    }

    public int getTimeRepre() {
        return timeRepre;
    }

    public void setTimeRepre(int timeRepre) {
        this.timeRepre = timeRepre;
    }

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    @Override
    public String toString() {
        return "GpsOperateHis{" +
                "id=" + id +
                ", equipmentId='" + equipmentId + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", companyId=" + companyId +
                ", chauffeurNo='" + chauffeurNo + '\'' +
                ", teamCode='" + teamCode + '\'' +
                ", emptyMile=" + emptyMile +
                ", emptyBeginTime=" + emptyBeginTime +
                ", workBeginTime=" + workBeginTime +
                ", workEndTime=" + workEndTime +
                ", unitPrice=" + unitPrice +
                ", loadMile=" + loadMile +
                ", slowCountTime=" + slowCountTime +
                ", operateMoney=" + operateMoney +
                ", evaluate=" + evaluate +
                ", tradeCode='" + tradeCode + '\'' +
                ", getOnLongitude=" + getOnLongitude +
                ", getOnLatitude=" + getOnLatitude +
                ", getOffLongitude=" + getOffLongitude +
                ", getOffLatitude=" + getOffLatitude +
                ", geoHash='" + geoHash + '\'' +
                ", timeRepre=" + timeRepre +
                '}';
    }
}
