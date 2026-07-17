
package designpatterns;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreationalPatternsTest {

    @Test
    void singletonShouldReturnSameInstance() {
        CollegeDatabase db1 = CollegeDatabase.getInstance();
        CollegeDatabase db2 = CollegeDatabase.getInstance();

        assertSame(db1, db2);
        assertEquals("Connected to college database", db1.connect());
    }

    @Test
    void factoryShouldCreateEmailNotification() {
        NotificationFactory factory = new NotificationFactory();

        Notification notification = factory.createNotification("email");

        assertTrue(notification instanceof EmailNotification);
        assertEquals("Email notification sent", notification.send());
    }

    @Test
    void factoryShouldCreateSMSNotification() {
        NotificationFactory factory = new NotificationFactory();

        Notification notification = factory.createNotification("sms");

        assertTrue(notification instanceof SMSNotification);
        assertEquals("SMS notification sent", notification.send());
    }

    @Test
    void abstractFactoryShouldCreateWindowsUI() {
        UIFactory factory = new WindowsFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        assertEquals("Windows button", button.render());
        assertEquals("Windows checkbox", checkbox.check());
    }

    @Test
    void abstractFactoryShouldCreateMacUI() {
        UIFactory factory = new MacFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        assertEquals("Mac button", button.render());
        assertEquals("Mac checkbox", checkbox.check());
    }

    @Test
    void builderShouldCreateStudentObject() {
        Student student = new Student.StudentBuilder()
                .setName("Ram")
                .setAge(20)
                .setCourse("Java")
                .build();

        assertEquals("Ram", student.getName());
        assertEquals(20, student.getAge());
        assertEquals("Java", student.getCourse());
    }

    @Test
    void prototypeShouldCloneStudentRecord() {
        StudentRecord original = new StudentRecord("Sita", "Software Engineering");

        StudentRecord copy = original.clone();

        assertNotSame(original, copy);
        assertEquals(original.getDetails(), copy.getDetails());
    }
}