package wasteDisposal.models.strategies;

import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;
import wasteDisposal.models.ProcessingDataImpl;

public class StorableStrategy extends AbstractStrategy{

    private static final int ENERGY_PRODUCED = 0;
    private static final int SHARE_OF_TOTAL_GARBAGE = 13;
    private static final int CAPITAL_EARNED = 0;
    private static final int PART_OF_TOTAL_GARBAGE = 65;

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyBalance = ENERGY_PRODUCED - (garbage.getVolumePerKg() * garbage.getWeight() * SHARE_OF_TOTAL_GARBAGE / 100.0);
        double capitalBalance = CAPITAL_EARNED - (garbage.getVolumePerKg() * garbage.getWeight() * PART_OF_TOTAL_GARBAGE / 100.0);

        return new ProcessingDataImpl(energyBalance, capitalBalance);
    }
}