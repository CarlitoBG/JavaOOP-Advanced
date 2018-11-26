package p05_barracks_wars_return_of_dependencies.core.commands;

import p05_barracks_wars_return_of_dependencies.contracts.Unit;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends Command {

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