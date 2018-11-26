package p02_kings_gambit.models;

import p02_kings_gambit.contracts.Observer;

public class Footman extends BasePerson implements Observer{

    public Footman(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.println(String.format("Footman %s is panicking!", super.getName()));
    }
}