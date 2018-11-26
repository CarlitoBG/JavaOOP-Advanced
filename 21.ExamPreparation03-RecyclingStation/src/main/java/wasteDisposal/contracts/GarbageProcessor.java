package wasteDisposal.contracts;

public interface GarbageProcessor {

    StrategyHolder getStrategyHolder();

    ProcessingData processWaste(Waste garbage);
}