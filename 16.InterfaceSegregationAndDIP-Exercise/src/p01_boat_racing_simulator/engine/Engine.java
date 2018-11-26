package p01_boat_racing_simulator.engine;

import p01_boat_racing_simulator.contracts.*;
import p01_boat_racing_simulator.contracts.CommandHandler;
import p01_boat_racing_simulator.contracts.Runnable;
import p01_boat_racing_simulator.exeptions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable{

    private static final String TERMINATE_COMMAND = "End";

    private InputReader reader;
    private OutputWriter writer;
    private CommandHandler commandHandler;

    public Engine(InputReader reader, OutputWriter writer, CommandHandler commandHandler) {
        this.reader = reader;
        this.writer = writer;
        this.commandHandler = commandHandler;
    }

    @Override
    public void run() {

        while (true) {
            String line = this.reader.readLine();
            List<String> tokens = Arrays.asList(line.split("\\\\"));
            String commandName = tokens.get(0);

            if (TERMINATE_COMMAND.equals(commandName)) {
                break;
            }

            try{
                List<String> commandParams = tokens.stream().skip(1).collect(Collectors.toList());
                String result = this.commandHandler.executeCommand(commandName, commandParams);

                if(result != null){
                    this.writer.writeLine(result);
                }
            }catch (NoSetRaceException | DuplicateModelException | RaceAlreadyExistsException | NonExistentModelException |
                    IllegalAccessException |NoSuchMethodException | InvocationTargetException |IllegalStateException |
                    IllegalArgumentException |InsufficientContestantsException | InstantiationException |
                    ClassNotFoundException e) {

                this.writer.writeLine(e.getMessage());
            }
        }
    }
}