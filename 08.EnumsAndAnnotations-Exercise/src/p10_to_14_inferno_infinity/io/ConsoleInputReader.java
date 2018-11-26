package p10_to_14_inferno_infinity.io;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleInputReader {

    private BufferedReader reader;

    public ConsoleInputReader(BufferedReader reader) {
        this.reader = reader;
    }

    public String readLine() {
        String result = null;

        try{
            result = this.reader.readLine();
        } catch(IOException ignored) {}

        return result;
    }
}