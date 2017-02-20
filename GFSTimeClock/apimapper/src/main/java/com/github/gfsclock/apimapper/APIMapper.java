package com.github.gfsclock.apimapper;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class APIMapper {

    static private ArrayList<EmployeeState> staticDB = new ArrayList<EmployeeState>();
    static private ArrayList<EmployeePunch> punchDB = new ArrayList<EmployeePunch>();

    /**
     * initList()
     * This function initializes a new list with some employees
     * Resets each time called, so it should only be called for testing
     */
    static public void initList() {
        // throw in some fake data
        staticDB = new ArrayList<EmployeeState>();
        punchDB = new ArrayList<EmployeePunch>();
        staticDB.add(new EmployeeState(57170, 0, 0));
        staticDB.add(new EmployeeState(57171, 1, 10));
        staticDB.add(new EmployeeState(57173, 0, 90));
        punchDB.add(new EmployeePunch(57171));
    }

    static public boolean ping() {
        // return true if connected;
        // server pinging here to known route with repeatable reply
        return true; // mocking
    }

    static public int stateByNum(int eNum) {
        // populate an employeeestate
        // we're mocking this
        for(Iterator<EmployeeState> i = staticDB.iterator(); i.hasNext();) {
            EmployeeState eInstance = i.next();
            if(eInstance.getNumber() == eNum) {
                return eInstance.getState();
            }
        }
        // didn't return in loop
        return -1;
    }

    static public int jobByNum(int eNum) {
        // populate an employeeestate
        // we're mocking this
        for(Iterator<EmployeeState> i = staticDB.iterator(); i.hasNext();) {
            EmployeeState eInstance = i.next();
            if(eInstance.getNumber() == eNum) {
                return eInstance.getJob();
            }
        }
        // didn't return in loop
        return -1;
    }

    static public ArrayList<EmployeePunch> punchByNum(int eNum) {
        ArrayList<EmployeePunch> resultList = new ArrayList<EmployeePunch>();
        for(Iterator<EmployeePunch> i = punchDB.iterator(); i.hasNext();) {
            EmployeePunch pInstance = i.next();
            if(pInstance.getNumber() == eNum) {
                resultList.add(pInstance);
            }
        }
        return resultList;
    }

    static public boolean punchForNum(int eNum) {
        // get state
        int eState = APIMapper.stateByNum(eNum);
        // TODO: Add other states
        switch(eState) {
            case 0:
                // no punch in
                punchDB.add(new EmployeePunch(eNum));
                return true;
            case 1:
                ArrayList<EmployeePunch> dragList = punchByNum(eNum);
                EmployeePunch pMod = dragList.remove(dragList.size());
                pMod.setEndDate(new Date());
                return true;
            default:
                return false;
        }
    }



}
