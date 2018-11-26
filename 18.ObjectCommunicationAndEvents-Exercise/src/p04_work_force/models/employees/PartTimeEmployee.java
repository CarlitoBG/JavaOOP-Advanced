package p04_work_force.models.employees;

public class PartTimeEmployee extends BaseEmployee{

    private static final int PART_TIME_EMPLOYEE_WORK_HOURS = 20;

    public PartTimeEmployee(String name) {
        super(name, PART_TIME_EMPLOYEE_WORK_HOURS);
    }
}