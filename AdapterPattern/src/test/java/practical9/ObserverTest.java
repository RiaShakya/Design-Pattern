package practical9;

import org.junit.jupiter.api.Test;
import practical9.GoodDesign.*;

import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

    @Test
    void studentNotification() {

        ResultPublisher publisher = new ResultPublisher();

        publisher.addObserver(new StudentObserver());
        publisher.publishResult();

        assertNotNull(publisher);

    }

    @Test
    void parentNotification() {

        ResultPublisher publisher = new ResultPublisher();

        publisher.addObserver(new ParentObserver());
        publisher.publishResult();

        assertNotNull(publisher);

    }

    @Test
    void departmentNotification() {

        ResultPublisher publisher = new ResultPublisher();

        publisher.addObserver(new DepartmentObserver());
        publisher.publishResult();

        assertNotNull(publisher);

    }

    @Test
    void observerRegistration() {

        ResultPublisher publisher = new ResultPublisher();

        publisher.addObserver(new StudentObserver());

        assertNotNull(publisher);

    }

    @Test
    void observerRemoval() {

        ResultPublisher publisher = new ResultPublisher();

        Observer observer = new StudentObserver();

        publisher.addObserver(observer);
        publisher.removeObserver(observer);

        assertNotNull(publisher);

    }

}