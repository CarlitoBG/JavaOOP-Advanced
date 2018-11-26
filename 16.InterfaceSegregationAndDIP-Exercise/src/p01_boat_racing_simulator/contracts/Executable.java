package p01_boat_racing_simulator.contracts;

import p01_boat_racing_simulator.exeptions.*;

public interface Executable {

    String execute() throws DuplicateModelException, NonExistentModelException, RaceAlreadyExistsException,
            NoSetRaceException, InsufficientContestantsException;
}