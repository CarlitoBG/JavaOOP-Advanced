package p01_logger.loggers;

import p01_logger.enumerations.LogType;
import p01_logger.interfaces.Handler;

public abstract class BaseLogger implements Handler{

    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    void passToSuccessor(LogType logType, String message){
        if (this.successor != null){
            this.successor.handle(logType, message);
        }
    }

    public abstract void handle(LogType logType, String message);
}