package p01_boat_racing_simulator.contracts;

import p01_boat_racing_simulator.exeptions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CommandHandler {
    String executeCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistentModelException,
            RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}