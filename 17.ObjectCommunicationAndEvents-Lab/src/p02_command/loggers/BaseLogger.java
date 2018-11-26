package p02_command.loggers;

import p02_command.enumerations.LogType;
import p02_command.interfaces.Handler;

public abstract class BaseLogger implements Handler {

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