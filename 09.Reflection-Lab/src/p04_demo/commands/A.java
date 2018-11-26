package p04_demo.commands;

import p04_demo.annotations.Command;
import p04_demo.interfaces.Executable;

@Command(value = "a")
public class A implements Executable{

    @Override
    public void execute(){
        System.out.println("Gosho");
    }
}