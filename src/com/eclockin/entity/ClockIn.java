package com.eclockin.entity;

import java.util.Date;

/**
 * 数据表类
 */
public class ClockIn {

    private String clockId;//数据ID
    private String id;//学生ID
    private String name;//姓名
    private Date date;//日期
    private String tmp;//体温

    public String getClockId() {
        return clockId;
    }

    public void setClockId(String clockId) {
        this.clockId = clockId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

}