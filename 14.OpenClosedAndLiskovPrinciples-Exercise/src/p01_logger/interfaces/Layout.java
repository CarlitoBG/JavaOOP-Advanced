package p01_logger.interfaces;

import p01_logger.enums.ReportLevel;

public interface Layout {

    String format(String dateTime, ReportLevel reportLevel, String message);
}