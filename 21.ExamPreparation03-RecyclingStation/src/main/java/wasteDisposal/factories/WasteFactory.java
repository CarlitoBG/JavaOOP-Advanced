package wasteDisposal.factories;

import wasteDisposal.contracts.Waste;
import wasteDisposal.models.wastes.Burnable;
import wasteDisposal.models.wastes.Recyclable;
import wasteDisposal.models.wastes.Storable;

public final class WasteFactory {

    public WasteFactory() { }

    public static Waste createRecyclable(String name, double weight, double volumePerKg) {
        return new Recyclable(name, weight, volumePerKg);
    }

    public static Waste createBurnable(String name, double weight, double volumePerKg) {
        return new Burnable(name, weight, volumePerKg);
    }

    public static Waste createStorable(String name, double weight, double volumePerKg) {
        return new Storable(name, weight, volumePerKg);
    }
}