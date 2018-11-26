package wasteDisposal.models.wastes;

import wasteDisposal.contracts.Waste;

public abstract class AbstractWaste implements Waste{

    private String name;
    private double weight;
    private double volumePerKg;

    AbstractWaste(String name, double weight, double volumePerKg) {
        this.name = name;
        this.weight = weight;
        this.volumePerKg = volumePerKg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}