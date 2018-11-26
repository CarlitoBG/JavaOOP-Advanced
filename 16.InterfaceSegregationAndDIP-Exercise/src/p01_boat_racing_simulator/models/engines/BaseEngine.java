package p01_boat_racing_simulator.models.engines;

import p01_boat_racing_simulator.contracts.BoatEngine;
import p01_boat_racing_simulator.utility.Constants;
import p01_boat_racing_simulator.utility.Validator;

public abstract class BaseEngine implements BoatEngine{

    private String model;
    private int output;

    BaseEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.validateHorsepower(horsepower);
        this.validateDisplacement(displacement);
        this.output = calculateOutput(horsepower,displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getOutput(){
        return this.output;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    private void validateHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
    }

    private void validateDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
    }

    protected abstract int calculateOutput(int horsepower, int displacement);
}