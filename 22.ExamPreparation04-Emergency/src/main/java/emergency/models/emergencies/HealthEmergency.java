package emergency.models.emergencies;

import emergency.enums.EmergencyLevel;
import emergency.utils.RegistrationTime;

public class HealthEmergency extends BaseEmergency{

    private Integer numberOfCasualties;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer numberOfCasualties) {
        super(description, emergencyLevel, registrationTime);
        this.numberOfCasualties = numberOfCasualties;
    }

    @Override
    public Integer getAdditionalParam() {
        return this.numberOfCasualties;
    }
}