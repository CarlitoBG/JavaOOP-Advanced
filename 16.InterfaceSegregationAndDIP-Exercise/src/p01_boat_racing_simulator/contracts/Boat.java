package p01_boat_racing_simulator.contracts;

public interface Boat extends Modelable{

    double calculateRaceSpeed(Race race);

    boolean hasEngine();
}