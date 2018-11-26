package p07_1984.factories;

import p07_1984.contracts.Observer;
import p07_1984.observer.Institution;

public class InstitutionFactory {

    public InstitutionFactory() {}

    public static Observer createInstitution(String name, String[] attributesToMonitor) {
        return new Institution(name, attributesToMonitor);
    }
}