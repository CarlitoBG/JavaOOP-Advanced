package p04_observer.executor.commands;

import p04_observer.interfaces.AttackGroup;
import p04_observer.interfaces.Command;

public class GroupAttackCommand implements Command {

    private AttackGroup attackGroup;

    public GroupAttackCommand(AttackGroup attackGroup) {
        this.attackGroup = attackGroup;
    }

    @Override
    public void execute() {
        this.attackGroup.groupAttack();
    }
}