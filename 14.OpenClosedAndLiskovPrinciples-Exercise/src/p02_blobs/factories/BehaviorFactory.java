package p02_blobs.factories;

import p02_blobs.interfaces.Behavior;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class BehaviorFactory {

    private static final String BEHAVIOR_PATH = "p02_blobs.models.behaviors.";

    private BehaviorFactory() {
    }

    public static Behavior create(String behaviorType) {

        Behavior behavior;
        try {
            Class<?> behaviorClass = Class.forName(BEHAVIOR_PATH + behaviorType);

            Constructor<?> declaredConstructor = behaviorClass.getDeclaredConstructor();
            behavior = (Behavior) declaredConstructor.newInstance();

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                IllegalAccessException e) {
            return null;
        }

        return behavior;
    }
}