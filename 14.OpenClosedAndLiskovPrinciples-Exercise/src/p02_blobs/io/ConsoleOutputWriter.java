package p02_blobs.io;

import p02_blobs.interfaces.Writer;

public class ConsoleOutputWriter implements Writer{

    @Override
    public void writeLine(String output){
        System.out.println(output);
    }
}