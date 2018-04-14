package com.qg.taxi.model;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/3/29
 * No struggle, talent how to match the willfulness.
 * Description:
 */
public class DriverInfo {
    private String number;

    private double income;

    private double emptyMileage;

    private String day;

    private int hour;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public DriverInfo() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getEmptyMileage() {
        return emptyMileage;
    }

    public void setEmptyMileage(double emptyMileage) {
        this.emptyMileage = emptyMileage;
    }

    @Override
    public String toString() {
        return "DriverInfo{" +
                "number='" + number + '\'' +
                ", income=" + income +
                ", emptyMileage=" + emptyMileage +
                ", day='" + day + '\'' +
                ", hour=" + hour +
                '}';
    }
}
