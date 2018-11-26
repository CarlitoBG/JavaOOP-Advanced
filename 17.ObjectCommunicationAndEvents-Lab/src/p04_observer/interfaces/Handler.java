package p04_observer.interfaces;

import p04_observer.enumerations.LogType;

public interface Handler {
    void handle(LogType logType, String string);
    void setSuccessor(Handler handler);
}