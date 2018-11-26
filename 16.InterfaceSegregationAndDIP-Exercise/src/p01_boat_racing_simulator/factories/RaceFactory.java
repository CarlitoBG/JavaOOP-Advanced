package p01_boat_racing_simulator.factories;

import p01_boat_racing_simulator.contracts.Race;
import p01_boat_racing_simulator.models.RaceImpl;

public final class RaceFactory {

    private RaceFactory() { }

    public static Race createRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats){
        return new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
    }
}