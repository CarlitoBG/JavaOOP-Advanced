package p01_logger.models.appenders;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Layout;
import p01_logger.interfaces.OutputWriter;
import p01_logger.io.OutputWriterImpl;

public class ConsoleAppender extends BaseAppender{

    private OutputWriter outputWriter;

    public ConsoleAppender(Layout layout) {
        super(layout);
        this.outputWriter = new OutputWriterImpl();
    }

    @Override
    public void appendMessage(ReportLevel reportLevel, String dateTime, String message) {
        if (super.getReportLevel().ordinal() <= reportLevel.ordinal()){
            String log = this.getLayout().format(dateTime, reportLevel, message);
            this.increaseAppendedMessagesCount();
            this.outputWriter.writeLine(log);
        }
    }
}