package emergency.factories;

import emergency.contracts.Center;
import emergency.models.centers.FiremanServiceCenter;
import emergency.models.centers.MedicalServiceCenter;
import emergency.models.centers.PoliceServiceCenter;

public class CenterFactory {

    public CenterFactory() { }

    public static Center createFiremanServiceCenter(String name, Integer additionalParam) {
        return new FiremanServiceCenter(name, additionalParam);
    }

    public static Center createMedicalServiceCenter(String name, Integer additionalParam) {
        return new MedicalServiceCenter(name, additionalParam);
    }

    public static Center createPoliceServiceCenter(String name, Integer additionalParam) {
        return new PoliceServiceCenter(name, additionalParam);
    }
}