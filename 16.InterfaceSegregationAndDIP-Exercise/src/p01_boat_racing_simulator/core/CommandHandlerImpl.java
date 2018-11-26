package p01_boat_racing_simulator.core;

import p01_boat_racing_simulator.annotations.Inject;
import p01_boat_racing_simulator.contracts.CommandHandler;
import p01_boat_racing_simulator.contracts.BoatSimulatorController;
import p01_boat_racing_simulator.contracts.Executable;
import p01_boat_racing_simulator.exeptions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class CommandHandlerImpl implements CommandHandler {

    private static final String COMMAND_CLASS_PATH = "p01_boat_racing_simulator.core.commands.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private List<String> params;
    private BoatSimulatorController controller;

    public CommandHandlerImpl(BoatSimulatorController controller) {
        this.controller = controller;
    }

    public String executeCommand(String commandName, List<String> commandParams) throws DuplicateModelException,
            NonExistentModelException, RaceAlreadyExistsException,
            NoSetRaceException, InsufficientContestantsException, ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        this.params = commandParams;

        Class<?> commandClass = Class.forName(COMMAND_CLASS_PATH + commandName + COMMAND_CLASS_NAME_SUFFIX);
        Constructor<?> constructor = commandClass.getDeclaredConstructor();

        Executable command = (Executable) constructor.newInstance();
        this.injectDependencies(command);

        return command.execute();
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fieldsBaseCommand = executable.getClass().getSuperclass().getDeclaredFields();
        Field[] fieldsCommand = executable.getClass().getDeclaredFields();

        Field[] allFields = null;

        if (fieldsCommand.length > 0) {
            allFields = new Field[fieldsBaseCommand.length + fieldsCommand.length];

            System.arraycopy(fieldsBaseCommand, 0, allFields, 0, fieldsBaseCommand.length);
            System.arraycopy(fieldsCommand, 0, allFields, fieldsBaseCommand.length, fieldsCommand.length);
        }

        for (Field field : fieldsCommand.length > 0 ? allFields : fieldsBaseCommand) {
            if (field.isAnnotationPresent(Inject.class)) {
                Field[] currentFields = this.getClass().getDeclaredFields();

                for (Field currentField : currentFields) {
                    if (field.getType().equals(currentField.getType())) {
                        field.setAccessible(true);
                        field.set(executable, currentField.get(this));
                    }
                }
            }
        }
    }
}