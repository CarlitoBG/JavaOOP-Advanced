package p01_boat_racing_simulator.core.commands;

import p01_boat_racing_simulator.exeptions.*;

public class CreatePowerBoatCommand extends BaseCommand{

    @Override
    public String execute() throws DuplicateModelException, NonExistentModelException {
        return super.getController().createPowerBoat(super.getParams().get(0),Integer.parseInt(super.getParams().get(1)),
                super.getParams().get(2),super.getParams().get(3));
    }
}