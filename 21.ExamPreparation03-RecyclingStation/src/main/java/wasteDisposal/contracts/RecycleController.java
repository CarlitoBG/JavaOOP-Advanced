package wasteDisposal.contracts;

public interface RecycleController {

    String processGarbage(String name, double weight, double volumePerKg, String type);

    String status();

    String changeManagementRequirement(double energyBalance, double capitalBalance, String garbageType);
}