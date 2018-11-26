package p02_services.core;

import p02_services.interfaces.NotificationService;

public class OnlineStoreOrder {

    private NotificationService notification;

    public OnlineStoreOrder(NotificationService notification) {
        this.notification = notification;
    }

    public void process() {
        if (this.notification.isActive()){
            this.notification.sendNotification();
        }
    }
}