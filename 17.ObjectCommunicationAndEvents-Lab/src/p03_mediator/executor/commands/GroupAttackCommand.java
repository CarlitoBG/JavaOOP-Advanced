package p03_mediator.executor.commands;

import p03_mediator.interfaces.AttackGroup;
import p03_mediator.interfaces.Command;

public class GroupAttackCommand implements Command{

    private AttackGroup attackGroup;

    public GroupAttackCommand(AttackGroup attackGroup) {
        this.attackGroup = attackGroup;
    }

    @Override
    public void execute() {
        this.attackGroup.groupAttack();
    }
}