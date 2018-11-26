package p03_mediator.interfaces;

import p03_mediator.enumerations.LogType;

public interface Handler {
    void handle(LogType logType, String string);
    void setSuccessor(Handler handler);
}