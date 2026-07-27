package practical6;

import org.junit.jupiter.api.Test;
import practical6.GoodDesign.StudentRecord;
import practical6.GoodDesign.StudentRecordProxy;

import static org.junit.jupiter.api.Assertions.*;

public class ProxyTest {

    @Test
    void proxyExists() {

        StudentRecordProxy proxy =
                new StudentRecordProxy("ADMIN");

        assertNotNull(proxy);

    }

    @Test
    void adminWorks() {

        StudentRecord proxy =
                new StudentRecordProxy("ADMIN");

        assertDoesNotThrow(proxy::viewMarks);

    }

    @Test
    void studentWorks() {

        StudentRecord proxy =
                new StudentRecordProxy("STUDENT");

        assertDoesNotThrow(proxy::viewMarks);

    }

    @Test
    void proxyNotNull() {

        StudentRecordProxy proxy =
                new StudentRecordProxy("ADMIN");

        assertNotNull(proxy);

    }

}