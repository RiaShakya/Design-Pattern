package TestCases;

import adapter.EmailAdapter;
import adapter.NotificationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailAdapterTest {

    @Test
    void testAdapterObject() {

        NotificationService service =
                new EmailAdapter();

        assertNotNull(service);
    }

}