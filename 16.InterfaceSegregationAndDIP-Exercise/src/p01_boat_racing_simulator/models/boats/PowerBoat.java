package p01_boat_racing_simulator.models.boats;

import p01_boat_racing_simulator.contracts.BoatEngine;
import p01_boat_racing_simulator.contracts.Race;

public class PowerBoat extends BaseBoat{

    private BoatEngine firstEngine;
    private BoatEngine secondEngine;

    public PowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine) {
        super(model, weight);
        this.firstEngine = firstEngine;
        this.secondEngine = secondEngine;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.firstEngine.getOutput() + this.secondEngine.getOutput()) - super.getWeight() + (race.getOceanCurrentSpeed() / 5.0);
    }

    @Override
    public boolean hasEngine() {
        return true;
    }
}