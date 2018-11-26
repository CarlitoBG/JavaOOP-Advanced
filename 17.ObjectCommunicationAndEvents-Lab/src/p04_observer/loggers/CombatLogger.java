package p04_observer.loggers;

import p04_observer.enumerations.LogType;

public class CombatLogger extends BaseLogger {

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.ATTACK || logType == LogType.MAGIC){
            System.out.println(logType.name() + ": " + message);
        }
        super.passToSuccessor(logType, message);
    }
}