package wasteDisposal.models.wastes;

import wasteDisposal.annotations.Burning;

@Burning
public class Burnable extends AbstractWaste{

    public Burnable(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}