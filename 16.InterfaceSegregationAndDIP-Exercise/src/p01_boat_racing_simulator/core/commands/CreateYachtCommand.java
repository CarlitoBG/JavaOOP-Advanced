package p01_boat_racing_simulator.core.commands;

import p01_boat_racing_simulator.exeptions.*;

public class CreateYachtCommand extends BaseCommand{

    @Override
    public String execute() throws DuplicateModelException, NonExistentModelException {
        return super.getController().createYacht(super.getParams().get(0),Integer.parseInt(super.getParams().get(1)),
                super.getParams().get(2),Integer.parseInt(super.getParams().get(3)));
    }
}