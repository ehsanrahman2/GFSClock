package teamgfs.github.com.apimapper;

public class EmployeeState {
    private int employeeNum; // employee ids are left-padded with zeros
    private int employeeState; // finite states represented as int
    private int employeeJob;

    public EmployeeState(int eNum, int eState, int eJob) {
        employeeNum = eNum;
        employeeState = eState;
        employeeJob = eJob;
    }

    public void setNumber(int eNum) {
        employeeNum = eNum;
    }

    public void setState(int eState) {
        employeeState = eState;
    }

    public void setJob(int eJob) {
        employeeJob = eJob;
    }

    public int getNumber() {
        return employeeNum;
    }

    public int getState() {
        return employeeState;
    }

    public int getJob() {
        return employeeJob;
    }
}
