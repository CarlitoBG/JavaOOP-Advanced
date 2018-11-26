package p03_mediator.models;

import p03_mediator.interfaces.AttackGroup;
import p03_mediator.interfaces.Attacker;
import p03_mediator.interfaces.Target;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup{

    private List<Attacker> attackers;

    public Group() {
        this.attackers = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(Target target) {
        this.attackers.forEach(attacker -> attacker.setTarget(target));
    }

    @Override
    public void groupAttack() {
        this.attackers.forEach(Attacker::attack);
    }
}