package wasteDisposal.models.wastes;

import wasteDisposal.annotations.Recycling;

@Recycling
public class Recyclable extends AbstractWaste{

    public Recyclable(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}