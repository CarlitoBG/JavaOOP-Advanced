package p01_logger.loggers;

import p01_logger.enumerations.LogType;

public class EventLogger extends BaseLogger{

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.EVENT){
            System.out.println(logType.name() + ": " + message);
        }
        super.passToSuccessor(logType, message);
    }
}