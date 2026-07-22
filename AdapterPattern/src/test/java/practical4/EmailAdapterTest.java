package practical4;

import org.junit.jupiter.api.Test;
import practical4.GoodDesign.EmailAdapter;
import practical4.GoodDesign.LegacyEmailService;
import practical4.GoodDesign.NotificationService;
import practical4.GoodDesign.NotificationSystem;

import static org.junit.jupiter.api.Assertions.*;

public class EmailAdapterTest {

    @Test
    void adapterExists() {

        EmailAdapter adapter =
                new EmailAdapter(new LegacyEmailService());

        assertNotNull(adapter);

    }

    @Test
    void sendWorks() {

        NotificationService adapter =
                new EmailAdapter(new LegacyEmailService());

        adapter.sendNotification("Welcome to PCPS");

        assertNotNull(adapter);

    }

    @Test
    void delegateWorks() {

        NotificationSystem system =
                new NotificationSystem(
                        new EmailAdapter(new LegacyEmailService()));

        system.notifyStudent("Welcome to PCPS");

        assertNotNull(system);

    }

    @Test
    void adapterNotNull() {

        NotificationService adapter =
                new EmailAdapter(new LegacyEmailService());

        assertNotNull(adapter);

    }

}
