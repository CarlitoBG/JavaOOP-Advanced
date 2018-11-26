package p01_boat_racing_simulator.core.commands;

import p01_boat_racing_simulator.annotations.Inject;
import p01_boat_racing_simulator.contracts.BoatSimulatorController;
import p01_boat_racing_simulator.contracts.Executable;

import java.util.Collections;
import java.util.List;

public abstract class BaseCommand implements Executable{

    @Inject
    private List<String> params;

    @Inject
    private BoatSimulatorController controller;

    protected BaseCommand() { }

    List<String> getParams() {
        return Collections.unmodifiableList(this.params);
    }

    protected BoatSimulatorController getController() {
        return this.controller;
    }
}