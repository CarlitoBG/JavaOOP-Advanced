package p01_boat_racing_simulator.exeptions;

public class RaceAlreadyExistsException extends Exception {

    public RaceAlreadyExistsException(String message) {
        super(message);
    }
}