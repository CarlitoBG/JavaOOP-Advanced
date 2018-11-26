package emergency.models.centers;

import emergency.contracts.Center;
import emergency.contracts.Emergency;

public abstract class BaseEmergencyCenter implements Center {

    private String name;
    private Integer amountOfMaximumEmergencies;
    private Integer processedEmergenciesCount;

    BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.name = name;
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
        this.processedEmergenciesCount = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void processEmergency() {
        this.processedEmergenciesCount++;
    }

    @Override
    public Boolean isForRetirement() {
        return this.processedEmergenciesCount >= this.amountOfMaximumEmergencies;
    }
}