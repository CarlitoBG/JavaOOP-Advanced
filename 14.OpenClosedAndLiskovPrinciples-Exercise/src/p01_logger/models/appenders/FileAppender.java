package p01_logger.models.appenders;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.File;
import p01_logger.interfaces.Layout;
import p01_logger.models.files.LogFile;

public class FileAppender extends BaseAppender{

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    @Override
    public void appendMessage(ReportLevel reportLevel, String dateTime, String message) {
        if (super.getReportLevel().ordinal() <= reportLevel.ordinal()){
            String log = this.getLayout().format(dateTime, reportLevel, message);
            this.increaseAppendedMessagesCount();
            this.file.write(log);
        }
    }

    @Override
    public String toString() {
        return String.format("%s, File size: %s", super.toString(), this.file.size());
    }
}