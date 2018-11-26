package rpg.factories;

import rpg.contracts.Action;
import rpg.contracts.ActionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ActionFactoryImpl implements ActionFactory {

    private static final String ACTION_CLASS_PATH = "rpg.models.actions.";

    public Action create(String actionName) throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {

        Class<?> actionClass = Class.forName(ACTION_CLASS_PATH + actionName);
        Constructor<?> declaredConstructor = actionClass.getDeclaredConstructor();

        return (Action) declaredConstructor.newInstance();
    }
}