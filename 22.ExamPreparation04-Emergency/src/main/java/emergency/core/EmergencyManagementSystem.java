package emergency.core;

import emergency.collection.EmergencyRegister;
import emergency.contracts.Center;
import emergency.contracts.Emergency;
import emergency.contracts.ManagementSystem;
import emergency.contracts.Register;
import emergency.enums.EmergencyLevel;
import emergency.factories.CenterFactory;
import emergency.factories.EmergencyFactory;
import emergency.models.centers.FiremanServiceCenter;
import emergency.models.centers.MedicalServiceCenter;
import emergency.models.centers.PoliceServiceCenter;
import emergency.models.emergencies.HealthEmergency;
import emergency.models.emergencies.OrderEmergency;
import emergency.models.emergencies.PropertyEmergency;
import emergency.utils.RegistrationTime;

import java.util.*;

public class EmergencyManagementSystem implements ManagementSystem {

    private static final String PROPERTY = "Property";
    private static final String HEALTH = "Health";
    private static final String ORDER = "Order";

    private Map<String, Register<Emergency>> emergencies;
    private Map<String, Register<Center>> centers;
    private Map<String, Long> processedEmergencies;
    private Integer totalProcessedEmergencies;

    public EmergencyManagementSystem() {
        this.setEmergencies();
        this.setCenters();
        this.setProcessedEmergencies();
        this.totalProcessedEmergencies = 0;
    }

    @Override
    public String registerPropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer damage) {
        Emergency emergency = EmergencyFactory.createPropertyEmergency(description, emergencyLevel, registrationTime, damage);
        this.emergencies.get(PROPERTY).enqueueEmergency(emergency);
        return "Registered Public Property Emergency of level " + emergency.getEmergencyLevel() +
                " at " + emergency.getRegistrationTime() + ".";
    }

    @Override
    public String registerHealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer casualties) {
        Emergency emergency = EmergencyFactory.createHealthEmergency(description, emergencyLevel, registrationTime, casualties);
        this.emergencies.get(HEALTH).enqueueEmergency(emergency);
        return "Registered Public Health Emergency of level " + emergency.getEmergencyLevel() + " at " + emergency.getRegistrationTime() + ".";
    }

    @Override
    public String registerOrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String status) {
        Emergency emergency = EmergencyFactory.createOrderEmergency(description, emergencyLevel, registrationTime, status);
        this.emergencies.get(ORDER).enqueueEmergency(emergency);
        return "Registered Public Order Emergency of level " + emergency.getEmergencyLevel() + " at " + emergency.getRegistrationTime() + ".";
    }

    @Override
    public String registerFireServiceCenter(String name, Integer amountOfEmergencies) {
        Center center = CenterFactory.createFiremanServiceCenter(name, amountOfEmergencies);
        this.centers.get(PROPERTY).enqueueEmergency(center);
        return "Registered Fire Service Emergency Center - " + center.getName() + ".";
    }

    @Override
    public String registerMedicalServiceCenter(String name, Integer amountOfEmergencies) {
        Center center = CenterFactory.createMedicalServiceCenter(name, amountOfEmergencies);
        this.centers.get(HEALTH).enqueueEmergency(center);
        return "Registered Medical Service Emergency Center - " + center.getName() + ".";
    }

    @Override
    public String registerPoliceServiceCenter(String name, Integer amountOfEmergencies) {
        Center center = CenterFactory.createPoliceServiceCenter(name, amountOfEmergencies);
        this.centers.get(ORDER).enqueueEmergency(center);
        return "Registered Police Service Emergency Center - " + center.getName() + ".";
    }

    @Override
    public String processEmergencies(String type) {
        Register<Emergency> emergencyRegister = this.emergencies.get(type);
        Register<Center> centerRegister = this.centers.get(type);

        while (!emergencyRegister.isEmpty()) {
            if (centerRegister.isEmpty()) {
                return type + " Emergencies left to process: " + emergencyRegister.count() + ".";
            }

            Center emergencyCenter = centerRegister.dequeueEmergency();
            if (!emergencyCenter.isForRetirement()) {
                emergencyCenter.processEmergency();
                centerRegister.enqueueEmergency(emergencyCenter);

                Emergency emergency = emergencyRegister.dequeueEmergency();
                this.processedEmergencies.put(type, this.processedEmergencies.get(type) + emergency.getAdditionalParam());
                this.totalProcessedEmergencies++;
            }
        }
        return "Successfully responded to all " + type + " emergencies.";
    }

    @Override
    public String emergencyReport() {
        for (Register<Center> registerCenter : this.centers.values()) {
            List<Center> availableCenters = new LinkedList<>();

            while (!registerCenter.isEmpty()) {
                Center currentCenter = registerCenter.dequeueEmergency();
                if (!currentCenter.isForRetirement()) {
                    availableCenters.add(currentCenter);
                }
            }

            for (Center emergencyCenter : availableCenters) {
                registerCenter.enqueueEmergency(emergencyCenter);
            }
        }

        int currentlyRegisteredEmergencies = this.emergencies.entrySet().stream()
                .mapToInt(currentEmergencies -> currentEmergencies.getValue().count()).sum();

        return "PRRM Services Live Statistics\n" +
                "Fire Service Centers: " + this.centers.get(PROPERTY).count() + "\n" +
                "Medical Service Centers: " + this.centers.get(HEALTH).count() + "\n" +
                "Police Service Centers: " + this.centers.get(ORDER).count() + "\n" +
                "Total Processed Emergencies: " + this.totalProcessedEmergencies + "\n" +
                "Currently Registered Emergencies: " + currentlyRegisteredEmergencies + "\n" +
                "Total Property Damage Fixed: " + this.processedEmergencies.get(PROPERTY) + "\n" +
                "Total Health Casualties Saved: " + this.processedEmergencies.get(HEALTH) + "\n" +
                "Total Special Cases Processed: " + this.processedEmergencies.get(ORDER);
    }

    private void setEmergencies() {
        this.emergencies = new HashMap<>();
        this.emergencies.put(PROPERTY, new EmergencyRegister<>());
        this.emergencies.put(HEALTH, new EmergencyRegister<>());
        this.emergencies.put(ORDER, new EmergencyRegister<>());
    }

    private void setCenters() {
        this.centers = new HashMap<>();
        this.centers.put(PROPERTY, new EmergencyRegister<>());
        this.centers.put(HEALTH, new EmergencyRegister<>());
        this.centers.put(ORDER, new EmergencyRegister<>());
    }

    private void setProcessedEmergencies() {
        this.processedEmergencies = new HashMap<>();
        this.processedEmergencies.put(PROPERTY, 0L);
        this.processedEmergencies.put(HEALTH, 0L);
        this.processedEmergencies.put(ORDER, 0L);
    }
}