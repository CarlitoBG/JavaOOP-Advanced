package p04_observer.executor.commands;

import p04_observer.interfaces.AttackGroup;
import p04_observer.interfaces.Command;
import p04_observer.interfaces.ObservableTarget;
import p04_observer.interfaces.Target;

public class GroupTargetCommand implements Command {

    private AttackGroup attackGroup;
    private ObservableTarget target;

    public GroupTargetCommand(AttackGroup attackGroup, ObservableTarget target) {
        this.attackGroup = attackGroup;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attackGroup.groupTarget(this.target);
    }
}