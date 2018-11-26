package p01_boat_racing_simulator.contracts;

import p01_boat_racing_simulator.exeptions.DuplicateModelException;
import p01_boat_racing_simulator.exeptions.NonExistentModelException;

public interface CrudRepository<T extends Modelable> {

    T findByModel(String model) throws NonExistentModelException;

    void add(T item) throws DuplicateModelException;
}