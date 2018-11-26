package emergency.factories;

import emergency.contracts.Emergency;
import emergency.enums.EmergencyLevel;
import emergency.models.emergencies.HealthEmergency;
import emergency.models.emergencies.OrderEmergency;
import emergency.models.emergencies.PropertyEmergency;
import emergency.utils.RegistrationTime;

public class EmergencyFactory {

    public EmergencyFactory() { }

    public static Emergency createPropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer damage) {
        return new PropertyEmergency(description, emergencyLevel, registrationTime, damage);
    }

    public static Emergency createHealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer damage) {
        return new HealthEmergency(description, emergencyLevel, registrationTime, damage);
    }

    public static Emergency createOrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String status) {
        return new OrderEmergency(description, emergencyLevel, registrationTime, status);
    }
}