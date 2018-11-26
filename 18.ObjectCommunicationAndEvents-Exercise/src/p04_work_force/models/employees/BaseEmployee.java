package p04_work_force.models.employees;

import p04_work_force.contracts.Employee;

public abstract class BaseEmployee implements Employee{

    private String name;
    private int workHoursPerWeek;

    BaseEmployee(String name, int workHoursPerWeek) {
        this.name = name;
        this.workHoursPerWeek = workHoursPerWeek;
    }

    @Override
    public int getWorkHoursPerWeek() {
        return this.workHoursPerWeek;
    }
}