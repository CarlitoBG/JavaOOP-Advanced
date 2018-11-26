package p04_demo.commands;

import p04_demo.annotations.Command;
import p04_demo.interfaces.Executable;

@Command(value = "exit")
public class C implements Executable{

    @Override
    public void execute() {
        System.exit(0);
    }
}