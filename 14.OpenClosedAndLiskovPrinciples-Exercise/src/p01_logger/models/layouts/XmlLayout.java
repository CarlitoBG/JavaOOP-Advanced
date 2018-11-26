package p01_logger.models.layouts;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Layout;

public class XmlLayout implements Layout{

    @Override
    public String format(String dateTime, ReportLevel reportLevel, String message) {
        String xmlFormat = "<log>" +
                System.lineSeparator() +
                "\t<date>%s</date>" +
                System.lineSeparator() +
                "\t<level>%s</level>" +
                System.lineSeparator() +
                "\t<message>%s</message>" +
                System.lineSeparator() +
                "</log>";

        return String.format(xmlFormat, dateTime, reportLevel, message);
    }
}