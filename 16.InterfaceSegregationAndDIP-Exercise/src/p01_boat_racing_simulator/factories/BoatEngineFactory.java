package p01_boat_racing_simulator.factories;

import p01_boat_racing_simulator.contracts.BoatEngine;
import p01_boat_racing_simulator.models.engines.JetEngine;
import p01_boat_racing_simulator.models.engines.SterndriveEngine;

public final class BoatEngineFactory {

    private BoatEngineFactory() { }

    public static BoatEngine createJetEngine(String model, int horsepower, int displacement){
        return new JetEngine(model, horsepower, displacement);
    }

    public static BoatEngine createSterndriveEngine(String model,int horsepower,int displacement){
        return new SterndriveEngine(model, horsepower, displacement);
    }
}