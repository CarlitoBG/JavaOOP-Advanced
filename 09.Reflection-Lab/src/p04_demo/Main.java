package p04_demo;

import p04_demo.annotations.Command;
import p04_demo.interfaces.Executable;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File[] commands = new File("src/p04_demo/commands").listFiles();

        while (true){
            String command = reader.readLine();

            for (File file : commands) {
                Class c = Class.forName("p04_demo.commands." + file.getName().replace(".java", ""));
                Command a = (Command) c.getDeclaredAnnotation(Command.class);
                String value = a.value();

                Executable executable = (Executable) c.newInstance();

                if (value.equals(command)){
                    executable.execute();
                }
            }
        }
    }
}