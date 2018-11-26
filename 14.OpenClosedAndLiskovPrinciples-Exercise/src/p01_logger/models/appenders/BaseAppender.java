package p01_logger.models.appenders;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Appender;
import p01_logger.interfaces.Layout;

public abstract class BaseAppender implements Appender{

    private Layout layout;
    private ReportLevel reportLevel;
    private int appendedMessagesCount;

    BaseAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
        this.appendedMessagesCount = 0;
    }

    ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    Layout getLayout() {
        return this.layout;
    }

    void increaseAppendedMessagesCount(){
        this.appendedMessagesCount++;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        if (reportLevel != null) {
            this.reportLevel = reportLevel;
        }
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %s",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel.name(),
                this.appendedMessagesCount);
    }
}