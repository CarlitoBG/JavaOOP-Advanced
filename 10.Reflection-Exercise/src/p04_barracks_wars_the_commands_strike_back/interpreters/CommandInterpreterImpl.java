package p04_barracks_wars_the_commands_strike_back.interpreters;

import p04_barracks_wars_the_commands_strike_back.contracts.CommandInterpreter;
import p04_barracks_wars_the_commands_strike_back.contracts.Executable;
import p04_barracks_wars_the_commands_strike_back.contracts.Repository;
import p04_barracks_wars_the_commands_strike_back.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_NAME = "p04_barracks_wars_the_commands_strike_back.core.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        String correctCommandName = String.valueOf(commandName.charAt(0)).toUpperCase() + commandName.substring(1);

        Class<?> commandClass;
        try {
            commandClass = Class.forName(COMMANDS_PACKAGE_NAME + correctCommandName + COMMAND_SUFFIX);
        }catch (ClassNotFoundException cnfe){
            throw new RuntimeException("Invalid command!");
        }

        Constructor<?> constructor = commandClass.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
        Executable command = (Executable) constructor.newInstance(data, this.repository, this.unitFactory);
        return command;
    }
}