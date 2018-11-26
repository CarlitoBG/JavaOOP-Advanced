package p02_command.interfaces;

import p02_command.enumerations.LogType;

public interface Handler {
    void handle(LogType logType, String string);
    void setSuccessor(Handler handler);
}