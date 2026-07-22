package practical4.BadDesign;

public class NotificationSystem {

    public void sendNotification(LegacyEmailService service,
                                 String receiver,
                                 String message) {

        // Directly using the legacy method
        service.sendOldEmail(receiver, message);
    }
}