package p02_kings_gambit.models;

import p02_kings_gambit.contracts.Observer;

public class RoyalGuard extends BasePerson implements Observer{

    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.println(String.format("Royal Guard %s is defending!", super.getName()));
    }
}