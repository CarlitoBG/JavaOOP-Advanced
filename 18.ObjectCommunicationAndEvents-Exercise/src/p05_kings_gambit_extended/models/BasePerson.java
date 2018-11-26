package p05_kings_gambit_extended.models;

import p05_kings_gambit_extended.contracts.Observer;

public abstract class BasePerson implements Observer{

    private String name;
    private int health;

    BasePerson(String name) {
        this.name = name;
        this.health = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }
}