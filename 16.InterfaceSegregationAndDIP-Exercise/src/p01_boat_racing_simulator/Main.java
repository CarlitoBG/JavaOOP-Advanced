package p01_boat_racing_simulator;

import p01_boat_racing_simulator.contracts.*;
import p01_boat_racing_simulator.contracts.Runnable;
import p01_boat_racing_simulator.controllers.BoatSimulatorControllerImpl;
import p01_boat_racing_simulator.core.CommandHandlerImpl;
import p01_boat_racing_simulator.database.BoatSimulatorDatabase;
import p01_boat_racing_simulator.database.repositories.BoatEngineRepository;
import p01_boat_racing_simulator.database.repositories.BoatRepository;
import p01_boat_racing_simulator.engine.Engine;
import p01_boat_racing_simulator.io.ConsoleInputReader;
import p01_boat_racing_simulator.io.ConsoleOutputWriter;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        CrudRepository<Boat> boats = new BoatRepository<>();
        CrudRepository<BoatEngine> engines = new BoatEngineRepository<>();
        Database database = new BoatSimulatorDatabase(boats, engines);
        BoatSimulatorController controller = new BoatSimulatorControllerImpl(database);
        CommandHandler commandHandler = new CommandHandlerImpl(controller);

        Runnable engine = new Engine(reader, writer, commandHandler);

        engine.run();
    }
}