package p01_logger.models.layouts;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Layout;

public class SimpleLayout implements Layout{

    @Override
    public String format(String dateTime, ReportLevel reportLevel, String message){
        return String.format("%s - %s - %s", dateTime, reportLevel, message);
    }
}