package p01_boat_racing_simulator.core.commands;

import p01_boat_racing_simulator.exeptions.*;

public class StartRaceCommand extends BaseCommand {

    @Override
    public String execute() throws NoSetRaceException, InsufficientContestantsException {
        return super.getController().startRace();
    }
}