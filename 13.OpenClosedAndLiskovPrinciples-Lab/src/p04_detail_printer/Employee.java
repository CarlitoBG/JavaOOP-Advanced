package p04_detail_printer;

public class Employee {

    private String name;

    Employee(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee";
    }
}