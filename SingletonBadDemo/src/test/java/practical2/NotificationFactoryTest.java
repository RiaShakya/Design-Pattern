package practical2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationFactoryTest {

    @Test
    void testCreateEmailNotification() {

        Notification notification =
                NotificationFactory.createNotification("EMAIL");

        assertTrue(notification instanceof EmailNotification);
    }

    @Test
    void testCreateSMSNotification() {

        Notification notification =
                NotificationFactory.createNotification("SMS");

        assertTrue(notification instanceof SMSNotification);
    }

    @Test
    void testCreatePushNotification() {

        Notification notification =
                NotificationFactory.createNotification("PUSH");

        assertTrue(notification instanceof PushNotification);
    }

    @Test
    void testInvalidNotification() {

        assertThrows(IllegalArgumentException.class,
                () -> NotificationFactory.createNotification("ABC"));
    }
}