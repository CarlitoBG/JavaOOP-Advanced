package p01_boat_racing_simulator.io;

import p01_boat_racing_simulator.contracts.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter{

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

    @Override
    public void writeLine(String format, Object... arguments) {
        System.out.println(String.format(format, arguments));
    }
}