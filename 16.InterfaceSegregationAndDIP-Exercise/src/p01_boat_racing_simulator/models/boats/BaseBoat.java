package p01_boat_racing_simulator.models.boats;

import p01_boat_racing_simulator.contracts.Boat;
import p01_boat_racing_simulator.utility.Constants;
import p01_boat_racing_simulator.utility.Validator;

public abstract class BaseBoat implements Boat{

    private String model;
    private int weight;

    BaseBoat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    int getWeight() {
        return this.weight;
    }

    private void setWeight(int weight) {
        Validator.validatePropertyValue(weight, "Weight");
        this.weight = weight;
    }
}