package wasteDisposal.controller;

import wasteDisposal.contracts.*;
import wasteDisposal.factories.StrategyFactory;
import wasteDisposal.factories.WasteFactory;

public class RecycleControllerImpl implements RecycleController {

    private GarbageProcessor garbageProcessor;
    private double totalEnergy;
    private double totalCapital;
    private double requiredEnergy;
    private double requiredCapital;
    private String deniedType;

    public RecycleControllerImpl(GarbageProcessor garbageProcessor) {
        this.garbageProcessor = garbageProcessor;
        this.totalEnergy = 0.0;
        this.totalCapital = 0.0;
    }

    @Override
    public String processGarbage(String name, double weight, double volumePerKg, String type) {
        Waste waste = null;
        switch (type) {
            case "Recyclable":
                waste = WasteFactory.createRecyclable(name, weight, volumePerKg);
                break;
            case "Burnable":
                waste = WasteFactory.createBurnable(name, weight, volumePerKg);
                break;
            case "Storable":
                waste = WasteFactory.createStorable(name, weight, volumePerKg);
                break;
        }

        assert waste != null;
        if (this.deniedType != null && this.deniedType.equals(waste.getClass().getSimpleName())){
            if (this.totalEnergy < this.requiredEnergy || this.totalCapital < this.requiredCapital){
                return "Processing Denied!";
            }
        }

        GarbageDisposalStrategy strategy = StrategyFactory.createStrategy(type);
        this.garbageProcessor.getStrategyHolder().addStrategy(waste.getClass().getAnnotations()[0].annotationType(), strategy);

        ProcessingData product = this.garbageProcessor.processWaste(waste);

        this.totalEnergy += product.getEnergyBalance();
        this.totalCapital += product.getCapitalBalance();

        return String.format("%.2f kg of %s successfully processed!", waste.getWeight(), waste.getName());
    }

    @Override
    public String status() {
        return String.format("Energy: %.2f Capital: %.2f", this.totalEnergy, this.totalCapital);
    }

    @Override
    public String changeManagementRequirement(double energyBalance, double capitalBalance, String garbageType) {
        this.requiredEnergy = energyBalance;
        this.requiredCapital = capitalBalance;
        this.deniedType = garbageType;

        return "Management requirement changed!";
    }
}