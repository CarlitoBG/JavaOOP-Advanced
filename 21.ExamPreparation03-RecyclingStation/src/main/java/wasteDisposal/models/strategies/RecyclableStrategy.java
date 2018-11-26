package wasteDisposal.models.strategies;

import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;
import wasteDisposal.models.ProcessingDataImpl;

public class RecyclableStrategy extends AbstractStrategy{

    private static final int ENERGY_PRODUCED = 0;
    private static final int SHARE_OF_TOTAL_GARBAGE = 50;
    private static final int GARBAGE_VOLUME_PER_KG = 400;
    private static final int CAPITAL_USED = 0;

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyBalance = ENERGY_PRODUCED - (garbage.getVolumePerKg() * garbage.getWeight() * SHARE_OF_TOTAL_GARBAGE / 100.0);
        double capitalBalance = (garbage.getWeight() * GARBAGE_VOLUME_PER_KG) - CAPITAL_USED;

        return new ProcessingDataImpl(energyBalance, capitalBalance);
    }
}