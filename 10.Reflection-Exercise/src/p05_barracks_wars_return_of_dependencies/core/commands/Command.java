package p05_barracks_wars_return_of_dependencies.core.commands;

import p05_barracks_wars_return_of_dependencies.annotations.Inject;
import p05_barracks_wars_return_of_dependencies.contracts.Executable;
import p05_barracks_wars_return_of_dependencies.contracts.Repository;
import p05_barracks_wars_return_of_dependencies.contracts.UnitFactory;

public abstract class Command implements Executable {

    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected Command() {
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