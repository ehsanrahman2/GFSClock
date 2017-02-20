package com.github.gfsclock.apimapper;

import io.realm.RealmObject;

public class EmployeeModel extends RealmObject{
    private int id;
    private int dept;
    private int jobcode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public int getJobcode() {
        return jobcode;
    }

    public void setJobcode(int jobcode) {
        this.jobcode = jobcode;
    }
}
