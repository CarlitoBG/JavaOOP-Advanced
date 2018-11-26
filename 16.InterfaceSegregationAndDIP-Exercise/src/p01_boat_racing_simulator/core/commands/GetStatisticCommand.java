package p01_boat_racing_simulator.core.commands;

import p01_boat_racing_simulator.exeptions.*;

public class GetStatisticCommand extends BaseCommand{

    @Override
    public String execute() {
        return super.getController().getStatistics();
    }
}