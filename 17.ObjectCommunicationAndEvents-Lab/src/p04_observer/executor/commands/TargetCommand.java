package p04_observer.executor.commands;

import p04_observer.interfaces.Attacker;
import p04_observer.interfaces.Command;
import p04_observer.interfaces.Target;

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