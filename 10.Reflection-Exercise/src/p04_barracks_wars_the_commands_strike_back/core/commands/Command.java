package p04_barracks_wars_the_commands_strike_back.core.commands;

import p04_barracks_wars_the_commands_strike_back.contracts.Executable;
import p04_barracks_wars_the_commands_strike_back.contracts.Repository;
import p04_barracks_wars_the_commands_strike_back.contracts.UnitFactory;

public abstract class Command implements Executable{

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return this.data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }
}