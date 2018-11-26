package p02_services.core.implementations;

import p02_services.interfaces.NotificationService;

public class SmsNotificationService implements NotificationService{

    private boolean isActive;

    public SmsNotificationService(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public void sendNotification() {
        System.out.println("Send SMS!");
    }
}