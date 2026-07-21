package practical2;

public class NotificationFactory {

    public static Notification createNotification(String type) {

        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();

        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();

        } else if (type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();

        } else {
            throw new IllegalArgumentException("Invalid notification type");
        }
    }
}
