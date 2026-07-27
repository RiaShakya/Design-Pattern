package TestCases;

import observer.LibrarianObserver;
import observer.LibraryNotification;
import observer.MemberObserver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryNotificationTest {

    @Test
    void testObserver() {

        LibraryNotification notification =
                new LibraryNotification();

        notification.addObserver(new MemberObserver());

        notification.addObserver(new LibrarianObserver());

        assertNotNull(notification);
    }

}
