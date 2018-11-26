package p04_demo.commands;

import p04_demo.annotations.Command;
import p04_demo.interfaces.Executable;

@Command(value = "b")
public class B implements Executable{

    @Override
    public void execute(){
        System.out.println("Pesho");
    }
}