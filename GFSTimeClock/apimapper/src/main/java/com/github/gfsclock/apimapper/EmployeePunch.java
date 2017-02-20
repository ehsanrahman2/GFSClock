package com.github.gfsclock.apimapper;


import java.util.Date;

public class EmployeePunch {
    private int employeeNum;
    private Date startDate;
    private Date endDate;
    private enum punchType { CLOCK, MEAL, BREAK };

    public EmployeePunch(int eNum) {
        employeeNum = eNum;
        startDate = new Date();
    }

    public int getNumber() {
        return employeeNum;
    }

    public void setStartDate(Date sDate) {
        startDate = sDate;
    }

    public void setEndDate(Date eDate) {
        endDate = eDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

}
