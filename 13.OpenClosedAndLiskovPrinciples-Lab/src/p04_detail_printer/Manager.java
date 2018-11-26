package p04_detail_printer;

public class Manager extends Employee {

    private Iterable<String> documents;

    Manager(String name, Iterable<String> documents) {
        super(name);
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "Manager";
    }
}