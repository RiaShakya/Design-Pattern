package question2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class NotificationServiceTest {

    @Test
    void testSMSNotification() {

        NotificationService service =
                new NotificationService(new SMSNotification());

        assertDoesNotThrow(() ->
                service.sendNotification());
    }

    @Test
    void testEmailNotification() {

        NotificationService service =
                new NotificationService(new EmailNotification());

        assertDoesNotThrow(() ->
                service.sendNotification());
    }
}
