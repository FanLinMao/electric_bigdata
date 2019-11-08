package com.bunfly.electric.pojo;

public class MonthOfStationVqr {
    private String stationNo;

    private String date;

    private String upperTime;

    private String lowTime;

    private String vqr;

    public String getStationNo() {
        return stationNo;
    }

    public void setStationNo(String stationNo) {
        this.stationNo = stationNo == null ? null : stationNo.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getUpperTime() {
        return upperTime;
    }

    public void setUpperTime(String upperTime) {
        this.upperTime = upperTime == null ? null : upperTime.trim();
    }

    public String getLowTime() {
        return lowTime;
    }

    public void setLowTime(String lowTime) {
        this.lowTime = lowTime == null ? null : lowTime.trim();
    }

    public String getVqr() {
        return vqr;
    }

    public void setVqr(String vqr) {
        this.vqr = vqr == null ? null : vqr.trim();
    }
}