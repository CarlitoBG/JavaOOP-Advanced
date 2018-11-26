package p01_boat_racing_simulator.core.commands;

import p01_boat_racing_simulator.exeptions.*;

public class OpenRaceCommand extends BaseCommand{

    @Override
    public String execute() throws RaceAlreadyExistsException {
        return super.getController().openRace(Integer.parseInt(super.getParams().get(0)),
                Integer.parseInt(super.getParams().get(1)),Integer.parseInt(super.getParams().get(2)),
                Boolean.parseBoolean(super.getParams().get(3)));
    }
}