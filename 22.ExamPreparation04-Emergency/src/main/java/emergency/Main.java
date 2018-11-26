package emergency;

import emergency.contracts.CommandHandler;
import emergency.contracts.InputReader;
import emergency.contracts.ManagementSystem;
import emergency.contracts.OutputWriter;
import emergency.contracts.Runnable;
import emergency.core.EmergencyManagementSystem;
import emergency.engine.Engine;
import emergency.handler.CommandHandlerImpl;
import emergency.io.ConsoleInputReader;
import emergency.io.ConsoleOutputWriter;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        ManagementSystem managementSystem = new EmergencyManagementSystem();
        CommandHandler commandHandler = new CommandHandlerImpl(managementSystem);
        Runnable engine = new Engine(reader, writer, commandHandler);

        engine.run();
    }
}