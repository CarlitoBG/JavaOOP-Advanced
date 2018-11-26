package p04_detail_printer;

import java.util.ArrayList;
import java.util.List;

public class DetailsPrinter {

    private Iterable<Employee> employees;

    public DetailsPrinter(Iterable<Employee> employees) {
        this.employees = employees;
    }

    private void printDetails() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Pesho"));
        employees.add(new Manager("Pesho", new ArrayList<>()));

        DetailsPrinter detailsPrinter = new DetailsPrinter(employees);
        detailsPrinter.printDetails();
    }
}