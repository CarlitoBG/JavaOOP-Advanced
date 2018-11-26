package p01_boat_racing_simulator.database.repositories;

import p01_boat_racing_simulator.contracts.BoatEngine;
import p01_boat_racing_simulator.contracts.CrudRepository;
import p01_boat_racing_simulator.contracts.Modelable;
import p01_boat_racing_simulator.exeptions.DuplicateModelException;
import p01_boat_racing_simulator.exeptions.NonExistentModelException;
import p01_boat_racing_simulator.utility.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatEngineRepository<T extends Modelable> implements CrudRepository<BoatEngine>{

    private Map<String, BoatEngine> boatsEngines;

    public BoatEngineRepository() {
        this.boatsEngines = new LinkedHashMap<>();
    }

    @Override
    public void add(BoatEngine boatEngine) throws DuplicateModelException {
        if (this.boatsEngines.containsKey(boatEngine.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.boatsEngines.put(boatEngine.getModel(), boatEngine);
    }

    @Override
    public BoatEngine findByModel(String model) throws NonExistentModelException {
        if (!this.boatsEngines.containsKey(model)) {
            throw new NonExistentModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }
        return this.boatsEngines.get(model);
    }
}