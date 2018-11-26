package p03_mediator.executor.commands;

import p03_mediator.interfaces.AttackGroup;
import p03_mediator.interfaces.Command;
import p03_mediator.interfaces.Target;

public class GroupTargetCommand implements Command{

    private AttackGroup attackGroup;
    private Target target;

    public GroupTargetCommand(AttackGroup attackGroup, Target target) {
        this.attackGroup = attackGroup;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attackGroup.groupTarget(this.target);
    }
}