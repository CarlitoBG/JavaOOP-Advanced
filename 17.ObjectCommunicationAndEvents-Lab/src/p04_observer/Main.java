package p04_observer;

import p04_observer.executor.CommandExecutor;
import p04_observer.executor.commands.GroupAttackCommand;
import p04_observer.executor.commands.GroupTargetCommand;
import p04_observer.interfaces.*;
import p04_observer.loggers.CombatLogger;
import p04_observer.loggers.EventLogger;
import p04_observer.models.Group;
import p04_observer.models.heroes.Warrior;
import p04_observer.models.targets.Dragon;

public class Main {
    public static void main(String[] args) {

        Handler combatHandler = new CombatLogger();
        Handler eventHandler = new EventLogger();

        combatHandler.setSuccessor(eventHandler);

        ObservableAttacker attacker1 = new Warrior("Pesho", 5, combatHandler);
        ObservableAttacker attacker2 = new Warrior("Gosho", 5, combatHandler);
        ObservableAttacker attacker3 = new Warrior("Stamat", 5, combatHandler);
        ObservableAttacker attacker4 = new Warrior("Ivan", 5, combatHandler);
        ObservableTarget target = new Dragon("Dragon", 20, 8, combatHandler);

        AttackGroup attackGroup = new Group();
        attackGroup.addMember(attacker1);
        attackGroup.addMember(attacker2);
        attackGroup.addMember(attacker3);
        attackGroup.addMember(attacker4);

        target.register(attacker1);
        target.register(attacker2);
        target.register(attacker3);
        target.register(attacker4);

        Executor executor = new CommandExecutor();
        Command groupTarget = new GroupTargetCommand(attackGroup, target);
        Command groupAttack = new GroupAttackCommand(attackGroup);

        executor.executeCommand(groupTarget);
        executor.executeCommand(groupAttack);
    }
}