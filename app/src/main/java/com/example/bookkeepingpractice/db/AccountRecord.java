package com.example.bookkeepingpractice.db;

public class AccountRecord {
    int id;
    String title;
    String remark;
    float amount;
    String time;
    int year;
    int month;
    int day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    public AccountRecord() {
    }

    public AccountRecord(int id, String title, String remark, float amount, String time, int year, int month, int day){
        this.id = id;
        this.title = title;
        this.remark = remark;
        this.amount = amount;
        this.time = time;
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
