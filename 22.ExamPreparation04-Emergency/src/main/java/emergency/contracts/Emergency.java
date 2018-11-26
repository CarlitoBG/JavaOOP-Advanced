package emergency.contracts;

import emergency.enums.EmergencyLevel;
import emergency.utils.RegistrationTime;

public interface Emergency {

    EmergencyLevel getEmergencyLevel();

    RegistrationTime getRegistrationTime();

    Integer getAdditionalParam();
}