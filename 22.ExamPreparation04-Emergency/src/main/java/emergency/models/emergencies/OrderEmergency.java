package emergency.models.emergencies;

import emergency.enums.EmergencyLevel;
import emergency.utils.RegistrationTime;

public class OrderEmergency extends BaseEmergency {

    private static final String SPECIAL = "Special";

    private String status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String status) {
        super(description, emergencyLevel, registrationTime);
        this.status = status;
    }

    @Override
    public Integer getAdditionalParam() {
        if(SPECIAL.equals(this.status)) {
            return 1;
        } else {
            return 0;
        }
    }
}