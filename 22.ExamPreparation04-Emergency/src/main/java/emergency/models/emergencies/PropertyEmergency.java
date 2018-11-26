package emergency.models.emergencies;

import emergency.enums.EmergencyLevel;
import emergency.utils.RegistrationTime;

public class PropertyEmergency extends BaseEmergency{

    private Integer damage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer damage) {
        super(description, emergencyLevel, registrationTime);
        this.damage = damage;
    }

    @Override
    public Integer getAdditionalParam() {
        return this.damage;
    }
}