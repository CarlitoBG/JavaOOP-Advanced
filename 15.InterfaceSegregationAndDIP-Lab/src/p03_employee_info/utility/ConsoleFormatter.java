package p03_employee_info.utility;

import p03_employee_info.interfaces.Formatter;
import p03_employee_info.models.Employee;

public class ConsoleFormatter implements Formatter{

    @Override
    public String format(Iterable<Employee> employees) {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }

        return sb.toString();
    }
}