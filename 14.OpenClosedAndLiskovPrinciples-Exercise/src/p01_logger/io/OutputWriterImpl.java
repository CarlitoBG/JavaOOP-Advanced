package p01_logger.io;

import p01_logger.interfaces.OutputWriter;

public class OutputWriterImpl implements OutputWriter {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}