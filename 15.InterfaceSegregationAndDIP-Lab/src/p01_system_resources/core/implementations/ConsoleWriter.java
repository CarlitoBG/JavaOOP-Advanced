package p01_system_resources.core.implementations;

import p01_system_resources.interfaces.Writer;

public class ConsoleWriter implements Writer{

    @Override
    public void println(String string) {
        System.out.println(string);
    }
}