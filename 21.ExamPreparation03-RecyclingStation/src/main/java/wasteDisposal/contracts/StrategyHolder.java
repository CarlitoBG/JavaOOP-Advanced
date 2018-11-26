package wasteDisposal.contracts;

import java.util.Map;

public interface StrategyHolder {

    Map<Class, GarbageDisposalStrategy> getDisposalStrategies();

    boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy);

    boolean removeStrategy(Class annotationClass);
}