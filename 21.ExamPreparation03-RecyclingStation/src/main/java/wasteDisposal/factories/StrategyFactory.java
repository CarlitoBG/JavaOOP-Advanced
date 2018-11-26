package wasteDisposal.factories;

import wasteDisposal.contracts.GarbageDisposalStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class StrategyFactory {

    private static final String PATH = "wasteDisposal.models.strategies.";

    private StrategyFactory() { }

    @SuppressWarnings("unchecked")
    public static GarbageDisposalStrategy createStrategy(String type) {
        try {
            Class<GarbageDisposalStrategy> strategyClass = (Class<GarbageDisposalStrategy>) Class.forName(PATH + type + "Strategy");
            Constructor<GarbageDisposalStrategy> strategyConstructor = strategyClass.getDeclaredConstructor();

            return strategyConstructor.newInstance();

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}