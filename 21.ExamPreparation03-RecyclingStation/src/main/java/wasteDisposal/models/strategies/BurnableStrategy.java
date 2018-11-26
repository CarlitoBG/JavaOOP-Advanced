package wasteDisposal.models.strategies;

import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;
import wasteDisposal.models.ProcessingDataImpl;

public class BurnableStrategy extends AbstractStrategy {

    private static final int BALANCE_OF_PRODUCED_AND_USED_ENERGY = 80;
    private static final int CAPITAL_EARNED = 0;
    private static final int CAPITAL_USED = 0;

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyBalance = garbage.getVolumePerKg() * garbage.getWeight() * BALANCE_OF_PRODUCED_AND_USED_ENERGY / 100.0;
        double capitalBalance = CAPITAL_EARNED - CAPITAL_USED;

        return new ProcessingDataImpl(energyBalance, capitalBalance);
    }
}