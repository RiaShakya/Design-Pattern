package TestCases;

import org.junit.jupiter.api.Test;
import proxy.LibraryProxy;

import static org.junit.jupiter.api.Assertions.*;

class LibraryProxyTest {

    @Test
    void testProxyCreation() {

        LibraryProxy proxy =
                new LibraryProxy("LIBRARIAN");

        assertNotNull(proxy);
    }

}
