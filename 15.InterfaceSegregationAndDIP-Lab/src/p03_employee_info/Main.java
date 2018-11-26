package p03_employee_info;

import p03_employee_info.controller.EmployeeInfoProvider;
import p03_employee_info.engine.ConsoleClient;
import p03_employee_info.interfaces.Formatter;
import p03_employee_info.interfaces.InfoProvider;
import p03_employee_info.utility.ConsoleFormatter;

public class Main {
    public static void main(String[] args) {

        InfoProvider employeeInfo = new EmployeeInfoProvider();
        Formatter formatter = new ConsoleFormatter();

        ConsoleClient consoleClient = new ConsoleClient(formatter, employeeInfo);

        System.out.println(consoleClient.formatByName());
        System.out.println(consoleClient.formatBySalary());
    }
}