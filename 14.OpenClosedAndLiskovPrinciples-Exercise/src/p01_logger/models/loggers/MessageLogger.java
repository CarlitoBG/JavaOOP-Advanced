package p01_logger.models.loggers;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Appender;
import p01_logger.interfaces.Logger;

public class MessageLogger implements Logger{

    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logError(String time, String message) {
        this.logMessage(time, message, ReportLevel.ERROR);
    }

    @Override
    public void logInfo(String time, String message) {
        this.logMessage(time, message, ReportLevel.INFO);
    }

    @Override
    public void logWarning(String time, String message) {
        this.logMessage(time, message, ReportLevel.WARNING);
    }

    @Override
    public void logCritical(String time, String message) {
        this.logMessage(time, message, ReportLevel.CRITICAL);
    }

    @Override
    public void logFatal(String time, String message) {
        this.logMessage(time, message, ReportLevel.FATAL);
    }

    private void logMessage(String dateTime, String message, ReportLevel reportLevel) {
        for (Appender appender : this.appenders) {
            appender.appendMessage(reportLevel, dateTime, message);
        }
    }
}