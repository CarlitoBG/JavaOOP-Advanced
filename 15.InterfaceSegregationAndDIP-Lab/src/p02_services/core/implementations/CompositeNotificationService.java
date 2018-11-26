package p02_services.core.implementations;

import p02_services.interfaces.NotificationService;

public class CompositeNotificationService implements NotificationService{

    private boolean isActive;
    private NotificationService[] notificationServices;

    public CompositeNotificationService(boolean isActive, NotificationService... notificationServices) {
        this.isActive = isActive;
        this.notificationServices = notificationServices;
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public void sendNotification() {
        for (NotificationService notificationService : notificationServices) {
            if (notificationService.isActive()){
                notificationService.sendNotification();
            }
        }
    }
}