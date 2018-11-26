package p01_boat_racing_simulator.exeptions;

public class NonExistentModelException extends Exception {

    public NonExistentModelException(String message) {
        super(message);
    }
}