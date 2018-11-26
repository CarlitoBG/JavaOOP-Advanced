package p01_boat_racing_simulator.contracts;

public interface Database {

    CrudRepository<Boat> getBoats();

    CrudRepository<BoatEngine> getEngines();
}