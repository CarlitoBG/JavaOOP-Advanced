package p01_boat_racing_simulator.database.repositories;

import p01_boat_racing_simulator.contracts.Boat;
import p01_boat_racing_simulator.contracts.CrudRepository;
import p01_boat_racing_simulator.utility.Constants;
import p01_boat_racing_simulator.contracts.Modelable;
import p01_boat_racing_simulator.exeptions.DuplicateModelException;
import p01_boat_racing_simulator.exeptions.NonExistentModelException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BoatRepository<T extends Modelable> implements CrudRepository<Boat> {

    private Map<String, Boat> boats;

    public BoatRepository() {
        this.boats = new LinkedHashMap<>();
    }

    @Override
    public void add(Boat boat) throws DuplicateModelException {
        if (this.boats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.boats.put(boat.getModel(), boat);
    }

    @Override
    public Boat findByModel(String model) throws NonExistentModelException {
        if (!this.boats.containsKey(model)) {
            throw new NonExistentModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }
        return this.boats.get(model);
    }
}