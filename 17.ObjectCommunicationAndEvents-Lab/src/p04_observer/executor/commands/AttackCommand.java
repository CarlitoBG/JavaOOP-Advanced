package p04_observer.executor.commands;

import p04_observer.interfaces.Attacker;
import p04_observer.interfaces.Command;

public class AttackCommand implements Command {

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.attack();
    }
}