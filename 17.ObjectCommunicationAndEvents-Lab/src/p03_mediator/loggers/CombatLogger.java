package p03_mediator.loggers;

import p03_mediator.enumerations.LogType;

public class CombatLogger extends BaseLogger {

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.ATTACK || logType == LogType.MAGIC){
            System.out.println(logType.name() + ": " + message);
        }
        super.passToSuccessor(logType, message);
    }
}