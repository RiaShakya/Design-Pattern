package practical10;

import org.junit.jupiter.api.Test;
import practical10.GoodDesign.*;

import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {

    @Test
    void transcriptWorks() {

        StudentPortal portal = new StudentPortal();

        portal.setCommand(new TranscriptRequest());
        portal.submitRequest();

        assertNotNull(portal);

    }

    @Test
    void certificateWorks() {

        StudentPortal portal = new StudentPortal();

        portal.setCommand(new CertificateRequest());
        portal.submitRequest();

        assertNotNull(portal);

    }

    @Test
    void idCardWorks() {

        StudentPortal portal = new StudentPortal();

        portal.setCommand(new IDCardRequest());
        portal.submitRequest();

        assertNotNull(portal);

    }

    @Test
    void libraryCardWorks() {

        StudentPortal portal = new StudentPortal();

        portal.setCommand(new LibraryCardRequest());
        portal.submitRequest();

        assertNotNull(portal);

    }

    @Test
    void commandNotNull() {

        RequestCommand command = new TranscriptRequest();

        assertNotNull(command);

    }

}
