package p01_boat_racing_simulator.controllers;

import p01_boat_racing_simulator.contracts.*;
import p01_boat_racing_simulator.factories.BoatEngineFactory;
import p01_boat_racing_simulator.factories.BoatFactory;
import p01_boat_racing_simulator.factories.RaceFactory;
import p01_boat_racing_simulator.utility.Constants;
import p01_boat_racing_simulator.exeptions.*;

import java.util.*;
import java.util.stream.Collectors;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {

    private static final String[] POSITIONS = {"First", "Second", "Third"};

    private Database database;
    private Race currentRace;

    public BoatSimulatorControllerImpl(Database database) {
        this.database = database;
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, String engineType) throws DuplicateModelException {
        BoatEngine engine = null;
        switch (engineType) {
            case "Jet":
                engine = BoatEngineFactory.createJetEngine(model, horsepower, displacement);
                break;
            case "Sterndrive":
                engine = BoatEngineFactory.createSterndriveEngine(model, horsepower, displacement);
                break;
        }

        this.database.getEngines().add(engine);
        return String.format("Engine model %s with %s HP and displacement %s cm3 created successfully.", model, horsepower, displacement);
    }

    @Override
    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = BoatFactory.createRowBoat(model, weight, oars);

        this.database.getBoats().add(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = BoatFactory.createSailBoat(model, weight, sailEfficiency);

        this.database.getBoats().add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel)
            throws NonExistentModelException, DuplicateModelException {

        BoatEngine firstEngine = this.database.getEngines().findByModel(firstEngineModel);
        BoatEngine secondEngine = this.database.getEngines().findByModel(secondEngineModel);
        Boat boat = BoatFactory.createPowerBoat(model, weight, firstEngine, secondEngine);

        this.database.getBoats().add(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargoWeight)
            throws NonExistentModelException, DuplicateModelException {

        BoatEngine engine = this.database.getEngines().findByModel(engineModel);
        Boat boat = BoatFactory.createYacht(model, weight, engine, cargoWeight);

        this.database.getBoats().add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        this.validateRaceIsEmpty();
        this.currentRace = RaceFactory.createRace(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);

        return String.format("A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
                distance, windSpeed, oceanCurrentSpeed);
    }

    @Override
    public String signUpBoat(String model) throws NonExistentModelException, NoSetRaceException, DuplicateModelException {
        this.validateRaceIsSet();
        Boat boat = this.database.getBoats().findByModel(model);

        if (!this.currentRace.getAllowsMotorboats() && boat.hasEngine()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }
        this.currentRace.addParticipant(boat);

        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    @Override
    public String startRace() throws NoSetRaceException, InsufficientContestantsException {
        this.validateRaceIsSet();
        List<Boat> participants = this.currentRace.getParticipants();

        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        Comparator<Boat> raceSpeedByDescending = (boat1, boat2) -> {
            double raceSpeedOfBoat1 = boat1.calculateRaceSpeed(this.currentRace);
            double raceSpeedOfBoat2 = boat2.calculateRaceSpeed(this.currentRace);

            if (raceSpeedOfBoat1 <= 0 && raceSpeedOfBoat2 <= 0) {
                return 0;
            }
            return Double.compare(raceSpeedOfBoat2, raceSpeedOfBoat1);
        };

        participants.sort(raceSpeedByDescending);

        final int[] index = {0};

        StringBuilder sb = new StringBuilder();
        participants.stream().limit(3).forEach(boat -> sb.append(String.format("%s place: %s Model: %s Time: %s",
                POSITIONS[index[0]++], boat.getClass().getSimpleName(), boat.getModel(),
                boat.calculateRaceSpeed(this.currentRace) <= 0.0 ? "Did not finish!"
                        : String.format("%.2f sec", this.currentRace.getDistance() / boat.calculateRaceSpeed(this.currentRace))))
                .append(System.lineSeparator()));

        this.currentRace = null;

        return sb.toString().trim();
    }

    @Override
    public String getStatistics() {

        List<Boat> participants = this.currentRace.getParticipants();
        int countOfParticipants = participants.size();

        StringBuilder sb = new StringBuilder();

        participants.stream()
                .collect(Collectors.groupingBy((Boat boat) -> boat.getClass().getSimpleName()))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(boatsGroup -> {
                    String boatType = boatsGroup.getKey();
                    double percentage = ((double) boatsGroup.getValue().size() / countOfParticipants) * 100;
                    sb.append(String.format("%s -> %.2f%%", boatType, percentage)).append(System.lineSeparator());
                });

        return sb.toString().trim();
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }
}