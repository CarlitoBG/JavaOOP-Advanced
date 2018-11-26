package p04_work_force.models.employees;

public class StandartEmployee extends BaseEmployee{

    private static final int STANDART_EMPLOYEE_WORK_HOURS = 40;

    public StandartEmployee(String name) {
        super(name, STANDART_EMPLOYEE_WORK_HOURS);
    }
}