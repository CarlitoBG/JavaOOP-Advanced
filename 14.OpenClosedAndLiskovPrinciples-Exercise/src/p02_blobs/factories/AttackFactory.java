package p02_blobs.factories;

import p02_blobs.interfaces.Attack;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class AttackFactory {

    private static final String ATTACK_PATH = "p02_blobs.models.attacks.";

    private AttackFactory() {
    }

    public static Attack create(String attackType) {

        Attack attack;
        try {
            Class<?> attackClass = Class.forName(ATTACK_PATH + attackType);

            Constructor<?> declaredConstructor = attackClass.getDeclaredConstructor();
            attack = (Attack) declaredConstructor.newInstance();

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                IllegalAccessException e) {
            return null;
        }

        return attack;
    }
}