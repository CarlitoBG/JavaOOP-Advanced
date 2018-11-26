package p05_kings_gambit_extended.models;

import p05_kings_gambit_extended.contracts.Observer;

public class Footman extends BasePerson implements Observer{

    private static final int FOOTMAN_LIVE_POINTS = 2;

    public Footman(String name) {
        super(name);
        super.setHealth(FOOTMAN_LIVE_POINTS);
    }

    @Override
    public void update() {
        if (this.getHealth() > 0){
            System.out.println(String.format("Footman %s is panicking!", super.getName()));
        }
    }
}