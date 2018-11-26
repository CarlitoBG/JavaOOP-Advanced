package p01_logger.interfaces;

import p01_logger.enums.ReportLevel;

public interface Appender {

    void appendMessage(ReportLevel reportLevel, String dateTime, String message);

    void setReportLevel(ReportLevel reportLevel);
}