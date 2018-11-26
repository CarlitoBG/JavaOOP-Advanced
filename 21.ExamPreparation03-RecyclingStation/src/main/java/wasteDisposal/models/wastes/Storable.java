package wasteDisposal.models.wastes;

import wasteDisposal.annotations.Storing;

@Storing
public class Storable extends AbstractWaste{

    public Storable(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}