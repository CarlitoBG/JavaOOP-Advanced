package p01_boat_racing_simulator.factories;

import p01_boat_racing_simulator.contracts.Boat;
import p01_boat_racing_simulator.contracts.BoatEngine;
import p01_boat_racing_simulator.models.boats.PowerBoat;
import p01_boat_racing_simulator.models.boats.RowBoat;
import p01_boat_racing_simulator.models.boats.SailBoat;
import p01_boat_racing_simulator.models.boats.Yacht;

public final class BoatFactory {

    private BoatFactory() { }

    public static Boat createRowBoat(String model, int weight, int oars){
        return new RowBoat(model, weight, oars);
    }

    public static Boat createSailBoat(String model, int weight, int sailEfficiency){
        return new SailBoat(model, weight, sailEfficiency);
    }

    public static Boat createPowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine){
        return new PowerBoat(model, weight, firstEngine, secondEngine);
    }

    public static Boat createYacht(String model, int weight, BoatEngine firstEngine, int cargoWeight){
        return new Yacht(model, weight, firstEngine, cargoWeight);
    }
}