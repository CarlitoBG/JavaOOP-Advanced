package p01_boat_racing_simulator.models.boats;

import p01_boat_racing_simulator.contracts.BoatEngine;
import p01_boat_racing_simulator.contracts.Race;
import p01_boat_racing_simulator.utility.Validator;

public class Yacht extends BaseBoat{

    private BoatEngine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, BoatEngine engine, int cargoWeight) {
        super(model, weight);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return this.engine.getOutput() - (super.getWeight() + this.cargoWeight) + (race.getOceanCurrentSpeed() / 2.0);
    }

    @Override
    public boolean hasEngine() {
        return true;
    }
}