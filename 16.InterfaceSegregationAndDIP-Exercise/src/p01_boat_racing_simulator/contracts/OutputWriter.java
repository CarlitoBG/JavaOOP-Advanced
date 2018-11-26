package p01_boat_racing_simulator.contracts;

public interface OutputWriter {

    void writeLine(String line);

    void writeLine(String format, Object... arguments);
}