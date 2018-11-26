package wasteDisposal.contracts;

public interface GarbageDisposalStrategy {

    ProcessingData processGarbage(Waste garbage);
}