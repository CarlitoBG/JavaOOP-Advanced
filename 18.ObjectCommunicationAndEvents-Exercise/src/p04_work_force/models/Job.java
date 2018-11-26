package p04_work_force.models;

import p04_work_force.contracts.Employee;

public class Job {

    private String name;
    private int hoursOfWorkRequired;
    private Employee employee;

    public Job(String name, int hoursOfWorkRequired, Employee employee) {
        this.name = name;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.employee = employee;
    }

    public String update(){
        this.hoursOfWorkRequired -= this.employee.getWorkHoursPerWeek();
        if (this.hoursOfWorkRequired <= 0){
             return String.format("Job %s done!", this.name);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d", this.name, this.hoursOfWorkRequired);
    }
}