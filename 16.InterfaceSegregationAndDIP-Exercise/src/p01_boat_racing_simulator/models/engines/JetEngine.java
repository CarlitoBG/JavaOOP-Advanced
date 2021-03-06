package p01_boat_racing_simulator.models.engines;

public class JetEngine extends BaseEngine{

    private static final int MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    protected int calculateOutput(int horsepower, int displacement) {
        return horsepower * MULTIPLIER + displacement;
    }
}