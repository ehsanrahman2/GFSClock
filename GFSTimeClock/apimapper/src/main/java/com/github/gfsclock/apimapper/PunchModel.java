package com.github.gfsclock.apimapper;

import java.util.Date;

import io.realm.RealmObject;

public class PunchModel extends RealmObject{
    private int id;
    private String docket;
    private String jobCode; // used for job change
    private Date timeStamp;
    private String department; // used for job change

    public PunchModel(int id, String docket, Date timeStamp) {
        this.id = id;
        this.docket = docket;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocket() {
        return docket;
    }

    public void setDocket(String docket) {
        this.docket = docket;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
