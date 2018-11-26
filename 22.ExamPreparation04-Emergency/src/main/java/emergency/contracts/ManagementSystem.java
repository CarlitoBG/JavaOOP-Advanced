package emergency.contracts;

import emergency.enums.EmergencyLevel;
import emergency.utils.RegistrationTime;

public interface ManagementSystem {

    String registerPropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer damage);

    String registerHealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer casualties);

    String registerOrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String status);

    String registerFireServiceCenter(String name, Integer amountOfEmergencies);

    String registerMedicalServiceCenter(String name, Integer amountOfEmergencies);

    String registerPoliceServiceCenter(String name, Integer amountOfEmergencies);

    String processEmergencies(String type);

    String emergencyReport();
}