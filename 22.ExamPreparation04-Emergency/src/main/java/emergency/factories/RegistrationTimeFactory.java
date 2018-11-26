package emergency.factories;

import emergency.utils.RegistrationTime;

public class RegistrationTimeFactory {

    public RegistrationTimeFactory() { }

    public static RegistrationTime createRegistrationTime(String registrationTime) {
        return new RegistrationTime(registrationTime);
    }
}