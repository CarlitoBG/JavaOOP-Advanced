package emergency.models.emergencies;

import emergency.contracts.Emergency;
import emergency.enums.EmergencyLevel;
import emergency.utils.RegistrationTime;

public abstract class BaseEmergency implements Emergency{

    private String description;
    private EmergencyLevel emergencyLevel;
    private RegistrationTime registrationTime;

    BaseEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime) {
        this.description = description;
        this.emergencyLevel = emergencyLevel;
        this.registrationTime = registrationTime;
    }

    @Override
    public EmergencyLevel getEmergencyLevel() {
        return this.emergencyLevel;
    }

    @Override
    public RegistrationTime getRegistrationTime() {
        return this.registrationTime;
    }

    @Override
    public abstract Integer getAdditionalParam();
}