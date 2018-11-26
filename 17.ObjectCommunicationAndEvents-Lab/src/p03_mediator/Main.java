package p03_mediator;

import p03_mediator.executor.CommandExecutor;
import p03_mediator.executor.commands.AttackCommand;
import p03_mediator.executor.commands.GroupAttackCommand;
import p03_mediator.executor.commands.GroupTargetCommand;
import p03_mediator.executor.commands.TargetCommand;
import p03_mediator.interfaces.*;
import p03_mediator.loggers.CombatLogger;
import p03_mediator.loggers.EventLogger;
import p03_mediator.models.Group;
import p03_mediator.models.heroes.Warrior;
import p03_mediator.models.targets.Dragon;

public class Main {
    public static void main(String[] args) {

        Handler combatHandler = new CombatLogger();
        Handler eventHandler = new EventLogger();

        combatHandler.setSuccessor(eventHandler);

        Attacker attacker1 = new Warrior("Pesho", 5, combatHandler);
        Attacker attacker2 = new Warrior("Gosho", 5, combatHandler);
        Attacker attacker3 = new Warrior("Stamat", 5, combatHandler);
        Attacker attacker4 = new Warrior("Ivan", 5, combatHandler);
        Target target = new Dragon("Dragon", 20, 8, combatHandler);

        AttackGroup attackGroup = new Group();
        attackGroup.addMember(attacker1);
        attackGroup.addMember(attacker2);
        attackGroup.addMember(attacker3);
        attackGroup.addMember(attacker4);

        Executor executor = new CommandExecutor();
        Command groupTarget = new GroupTargetCommand(attackGroup, target);
        Command groupAttack = new GroupAttackCommand(attackGroup);

        executor.executeCommand(groupTarget);
        executor.executeCommand(groupAttack);
    }
}