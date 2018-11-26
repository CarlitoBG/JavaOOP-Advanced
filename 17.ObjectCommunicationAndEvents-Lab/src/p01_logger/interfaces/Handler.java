package p01_logger.interfaces;

import p01_logger.enumerations.LogType;

public interface Handler {
    void handle(LogType logType, String string);
    void setSuccessor(Handler handler);
}