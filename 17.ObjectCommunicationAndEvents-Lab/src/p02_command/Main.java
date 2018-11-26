package p02_command;

import p02_command.executor.CommandExecutor;
import p02_command.executor.commands.AttackCommand;
import p02_command.executor.commands.TargetCommand;
import p02_command.interfaces.*;
import p02_command.loggers.CombatLogger;
import p02_command.loggers.EventLogger;
import p02_command.models.heroes.Warrior;
import p02_command.models.targets.Dragon;

public class Main {
    public static void main(String[] args) {

        Handler combatHandler = new CombatLogger();
        Handler eventHandler = new EventLogger();

        combatHandler.setSuccessor(eventHandler);

        Attacker attacker = new Warrior("Warrior", 5, combatHandler);
        Target target = new Dragon("Dragon", 5, 8, combatHandler);

        Executor executor = new CommandExecutor();
        Command targetCommand = new TargetCommand(attacker, target);
        Command attackCommand = new AttackCommand(attacker);

        executor.executeCommand(targetCommand);
        executor.executeCommand(attackCommand);
        executor.executeCommand(attackCommand);
    }
}