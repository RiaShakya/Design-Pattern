package practical11;

import org.junit.jupiter.api.Test;
import practical11.GoodDesign.AdmissionApplication;
import practical11.GoodDesign.AdmissionState;
import practical11.GoodDesign.SubmittedState;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {

    @Test
    void submittedState() {

        AdmissionApplication application =
                new AdmissionApplication();

        application.showStatus();

        assertNotNull(application);

    }

    @Test
    void verifiedState() {

        AdmissionApplication application =
                new AdmissionApplication();

        application.nextState();
        application.showStatus();

        assertNotNull(application);

    }

    @Test
    void approvedState() {

        AdmissionApplication application =
                new AdmissionApplication();

        application.nextState();
        application.nextState();
        application.showStatus();

        assertNotNull(application);

    }

    @Test
    void enrolledState() {

        AdmissionApplication application =
                new AdmissionApplication();

        application.nextState();
        application.nextState();
        application.nextState();
        application.showStatus();

        assertNotNull(application);

    }

    @Test
    void stateNotNull() {

        AdmissionState state =
                new SubmittedState();

        assertNotNull(state);

    }

}
