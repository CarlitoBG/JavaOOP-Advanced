package p02_services;

import p02_services.core.OnlineStoreOrder;
import p02_services.core.implementations.CompositeNotificationService;
import p02_services.core.implementations.EmailNotificationService;
import p02_services.core.implementations.SmsNotificationService;
import p02_services.interfaces.NotificationService;

public class Main {
    public static void main(String[] args) {

        NotificationService service = new CompositeNotificationService(
                true, new SmsNotificationService(true), new EmailNotificationService(false));

        OnlineStoreOrder onlineStoreOrder = new OnlineStoreOrder(service);
        onlineStoreOrder.process();
    }
}