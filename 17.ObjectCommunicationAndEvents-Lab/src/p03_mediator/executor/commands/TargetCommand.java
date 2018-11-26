package p03_mediator.executor.commands;

import p03_mediator.interfaces.Attacker;
import p03_mediator.interfaces.Command;
import p03_mediator.interfaces.Target;

public class TargetCommand implements Command {

    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
    }
}