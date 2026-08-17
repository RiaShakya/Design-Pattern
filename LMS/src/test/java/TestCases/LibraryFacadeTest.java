package TestCases;

import facade.LibraryFacade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryFacadeTest {

    @Test
    void testFacadeCreation() {

        LibraryFacade facade = new LibraryFacade();

        assertNotNull(facade);
    }

}
