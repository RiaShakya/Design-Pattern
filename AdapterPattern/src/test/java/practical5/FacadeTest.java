package practical5;

import org.junit.jupiter.api.Test;
import practical5.GoodDesign.StudentRegistrationFacade;

import static org.junit.jupiter.api.Assertions.*;

public class FacadeTest {

    @Test
    void facadeExists() {

        StudentRegistrationFacade facade =
                new StudentRegistrationFacade();

        assertNotNull(facade);

    }

    @Test
    void registerWorks() {

        StudentRegistrationFacade facade =
                new StudentRegistrationFacade();

        facade.registerStudent("Ria Shakya");

        assertNotNull(facade);

    }

    @Test
    void facadeNotNull() {

        StudentRegistrationFacade facade =
                new StudentRegistrationFacade();

        assertNotNull(facade);

    }

}