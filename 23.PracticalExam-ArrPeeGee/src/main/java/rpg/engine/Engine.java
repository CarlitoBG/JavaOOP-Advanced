package rpg.engine;

import rpg.contracts.CommandHandler;
import rpg.contracts.Reader;
import rpg.contracts.Runnable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private static final String TERMINATE_COMMAND = "Peace";

    private Reader reader;
    private CommandHandler handler;

    public Engine(Reader reader, CommandHandler handler) {
        this.reader = reader;
        this.handler = handler;
    }

    @Override
    public void run() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        while (true) {
            List<String> tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("\\s+")));

            if (TERMINATE_COMMAND.equals(tokens.get(0))) {
                break;
            }

            this.handler.executeCommand(tokens.get(0), tokens.stream().skip(1).collect(Collectors.toList()));
        }
    }
}