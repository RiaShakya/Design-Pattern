package TestCases;

import org.junit.jupiter.api.Test;
import singleton.LibraryConfig;

import static org.junit.jupiter.api.Assertions.*;

class LibraryConfigTest {

    @Test
    void testSingletonInstance() {

        LibraryConfig config1 = LibraryConfig.getInstance();
        LibraryConfig config2 = LibraryConfig.getInstance();

        assertSame(config1, config2);
    }

    @Test
    void testLibraryDetails() {

        LibraryConfig config = LibraryConfig.getInstance();

        assertEquals("PCPS Library", config.getLibraryName());
        assertEquals("1.0", config.getSystemVersion());
    }
}
