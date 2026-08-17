package TestCases;

import factory.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

    @Test
    void testEmailFactory() {

        Notification notification =
                NotificationFactory.createNotification("email");

        assertTrue(notification instanceof EmailNotification);
    }

    @Test
    void testSMSFactory() {

        Notification notification =
                NotificationFactory.createNotification("sms");

        assertTrue(notification instanceof SMSNotification);
    }

    @Test
    void testPushFactory() {

        Notification notification =
                NotificationFactory.createNotification("push");

        assertTrue(notification instanceof PushNotification);
    }

}
