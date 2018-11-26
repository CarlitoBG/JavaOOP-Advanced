package p07_1984.observer;

import p07_1984.contracts.Observer;

import java.util.ArrayList;
import java.util.List;

public class Institution implements Observer{

    private String name;
    private String[] attributesToMonitor;
    private List<String> logs;

    public Institution(String name, String... attributes) {
        this.name = name;
        this.attributesToMonitor = attributes;
        this.logs = new ArrayList<>();
    }

    @Override
    public void update(String className, String id, String fieldName, String fieldType, String oldValue, String newValue) {
        for (String attribute : this.attributesToMonitor) {
            if (fieldName.equals(attribute)){
                String message = String.format("--%s(ID:%s) changed %s(%s) from %s to %s", className, id, fieldName, fieldType, oldValue, newValue);
                this.logs.add(message);
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s: %d changes registered",this.name, this.logs.size()));
        for (String message : this.logs) {
            sb.append(System.lineSeparator()).append(message);
        }
        return sb.toString();
    }
}