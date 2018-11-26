package p01_boat_racing_simulator.contracts;

import p01_boat_racing_simulator.exeptions.DuplicateModelException;

import java.util.List;

public interface Race {

    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats();

    void addParticipant(Boat boat) throws DuplicateModelException;

    List<Boat> getParticipants();
}