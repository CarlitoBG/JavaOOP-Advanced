package p04_observer.models;

import p04_observer.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {

    private List<ObservableAttacker> attackers;

    public Group() {
        this.attackers = new ArrayList<>();
    }

    @Override
    public void addMember(ObservableAttacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(ObservableTarget target) {
        this.attackers.forEach(attacker -> attacker.setTarget(target));
    }

    @Override
    public void groupAttack() {
        this.attackers.forEach(Attacker::attack);
    }
}