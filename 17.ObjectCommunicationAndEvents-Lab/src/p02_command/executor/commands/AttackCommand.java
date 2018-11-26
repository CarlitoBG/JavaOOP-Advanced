package p02_command.executor.commands;

import p02_command.interfaces.Attacker;
import p02_command.interfaces.Command;

public class AttackCommand implements Command{

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.attack();
    }
}