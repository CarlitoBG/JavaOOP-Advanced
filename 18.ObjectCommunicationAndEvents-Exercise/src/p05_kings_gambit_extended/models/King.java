package p05_kings_gambit_extended.models;

import p05_kings_gambit_extended.contracts.Lord;
import p05_kings_gambit_extended.contracts.Observer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class King extends BasePerson implements Lord {

    private Map<String, Observer> observers;

    public King(String name) {
        super(name);
        this.observers = new LinkedHashMap<>();
    }

    @Override
    public void update() {
        System.out.println(String.format("King %s is under attack!", super.getName()));
    }

    @Override
    public void attack() {
        this.notifyObservers();
    }

    @Override
    public void attachObserver(Observer observer) {
        this.observers.put(observer.getName(), observer);
    }

    @Override
    public void kill(String name) {
        Observer observer = this.observers.get(name);
        observer.setHealth(observer.getHealth() - 1);
        if (observer.getHealth() == 0){
            this.observers.remove(name);
        }
    }

    private void notifyObservers() {
        for (Observer observer : this.observers.values()) {
            observer.update();
        }
    }
}