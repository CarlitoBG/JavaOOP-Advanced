package wasteDisposal;

import wasteDisposal.contracts.*;
import wasteDisposal.controller.RecycleControllerImpl;
import wasteDisposal.engine.Engine;
import wasteDisposal.handlers.CommandHandlerImpl;
import wasteDisposal.io.ConsoleInputReader;
import wasteDisposal.io.ConsoleOutputWriter;
import wasteDisposal.models.miscellaneous.DefaultGarbageProcessor;
import wasteDisposal.models.miscellaneous.DefaultStrategyHolder;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        StrategyHolder strategyHolder = new DefaultStrategyHolder();
        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(strategyHolder);
        RecycleController controller = new RecycleControllerImpl(garbageProcessor);
        CommandHandler handler = new CommandHandlerImpl(controller);
        Engine engine = new Engine(reader, writer, handler);

        engine.run();
    }
}