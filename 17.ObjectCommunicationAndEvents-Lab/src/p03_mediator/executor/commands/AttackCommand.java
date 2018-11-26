package p03_mediator.executor.commands;

import p03_mediator.interfaces.Attacker;
import p03_mediator.interfaces.Command;

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