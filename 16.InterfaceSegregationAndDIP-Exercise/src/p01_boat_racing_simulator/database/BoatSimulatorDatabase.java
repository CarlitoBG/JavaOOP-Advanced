package p01_boat_racing_simulator.database;

import p01_boat_racing_simulator.contracts.*;
import p01_boat_racing_simulator.contracts.CrudRepository;

public class BoatSimulatorDatabase implements Database{

    private CrudRepository<Boat> boats;
    private CrudRepository<BoatEngine> engines;

    public BoatSimulatorDatabase(CrudRepository<Boat> boats, CrudRepository<BoatEngine> engines) {
        this.boats = boats;
        this.engines = engines;
    }

    @Override
    public CrudRepository<Boat> getBoats() {
        return this.boats;
    }

    @Override
    public CrudRepository<BoatEngine> getEngines() {
        return this.engines;
    }
}