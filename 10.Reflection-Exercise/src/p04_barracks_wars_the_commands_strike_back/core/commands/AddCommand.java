package p04_barracks_wars_the_commands_strike_back.core.commands;

import p04_barracks_wars_the_commands_strike_back.contracts.Repository;
import p04_barracks_wars_the_commands_strike_back.contracts.Unit;
import p04_barracks_wars_the_commands_strike_back.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends Command{

    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}