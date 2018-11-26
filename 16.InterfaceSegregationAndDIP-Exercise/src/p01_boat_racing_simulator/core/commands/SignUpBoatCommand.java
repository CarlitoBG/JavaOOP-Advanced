package p01_boat_racing_simulator.core.commands;

import p01_boat_racing_simulator.exeptions.*;

public class SignUpBoatCommand extends BaseCommand{

    @Override
    public String execute() throws DuplicateModelException, NonExistentModelException, NoSetRaceException {
        return super.getController().signUpBoat(super.getParams().get(0));
    }
}