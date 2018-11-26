package p01_logger;

import p01_logger.enumerations.LogType;
import p01_logger.interfaces.Handler;
import p01_logger.loggers.CombatLogger;
import p01_logger.loggers.EventLogger;

public class Main {
    public static void main(String[] args) {

        Handler combatHandler = new CombatLogger();
        Handler eventHandler = new EventLogger();

        combatHandler.setSuccessor(eventHandler);

        combatHandler.handle(LogType.ATTACK, "some attack");
        combatHandler.handle(LogType.ERROR, "some error");
        combatHandler.handle(LogType.EVENT, "some event");
    }
}