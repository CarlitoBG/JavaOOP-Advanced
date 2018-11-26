package p05_kings_gambit_extended.models;

import p05_kings_gambit_extended.contracts.Observer;

public class RoyalGuard extends BasePerson implements Observer{

    private static final int ROYAL_GUARD_LIVE_POINTS = 3;

    public RoyalGuard(String name) {
        super(name);
        super.setHealth(ROYAL_GUARD_LIVE_POINTS);
    }

    @Override
    public void update() {
        if (this.getHealth() > 0){
            System.out.println(String.format("Royal Guard %s is defending!", super.getName()));
        }
    }
}