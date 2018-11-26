package p02_command.executor.commands;

import p02_command.interfaces.Attacker;
import p02_command.interfaces.Command;
import p02_command.interfaces.Target;

public class TargetCommand implements Command{

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