package wasteDisposal.engine;

import wasteDisposal.contracts.CommandHandler;
import wasteDisposal.contracts.InputReader;
import wasteDisposal.contracts.OutputWriter;
import wasteDisposal.contracts.Runnable;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private static final String TERMINATE_COMMAND = "TimeToRecycle";

    private InputReader reader;
    private OutputWriter writer;
    private CommandHandler handler;

    public Engine(InputReader reader, OutputWriter writer, CommandHandler handler) {
        this.reader = reader;
        this.writer = writer;
        this.handler = handler;
    }

    @Override
    public void run() {
        while (true) {
            List<String> tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("(\\s+)|(\\|)")));

            if (TERMINATE_COMMAND.equals(tokens.get(0))) {
                break;
            }

            try {
                String result = this.handler.executeCommand(tokens.get(0), tokens.stream().skip(1).collect(Collectors.toList()));
                if (result != null) {
                    this.writer.writeLine(result);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException
                    | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}