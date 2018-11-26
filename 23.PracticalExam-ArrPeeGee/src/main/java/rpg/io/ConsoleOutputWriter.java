package rpg.io;

import rpg.contracts.Writer;

public class ConsoleOutputWriter implements Writer {

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}