package designpatterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StructuralPatternsTest {

    @Test
    void adapterShouldUseOldPrinterWithModernInterface() {
        OldPrinter oldPrinter = new OldPrinter();
        ModernPrinter adapter = new PrinterAdapter(oldPrinter);

        assertEquals("Printing using old printer", adapter.print());
    }

    @Test
    void bridgeShouldSendEmailAlertMessage() {
        MessageSender sender = new EmailSender();
        Message message = new AlertMessage(sender);

        assertEquals("Email sent: Exam starts tomorrow", message.send("Exam starts tomorrow"));
    }

    @Test
    void bridgeShouldSendSMSAlertMessage() {
        MessageSender sender = new SMSSender();
        Message message = new AlertMessage(sender);

        assertEquals("SMS sent: Fee due today", message.send("Fee due today"));
    }

    @Test
    void compositeShouldCalculateTotalStudents() {
        Department cs = new Department(50);
        Department bba = new Department(40);

        College college = new College();
        college.addDepartment(cs);
        college.addDepartment(bba);

        assertEquals(90, college.getStudentCount());
    }

    @Test
    void decoratorShouldAddMilkToCoffee() {
        Coffee coffee = new SimpleCoffee();
        Coffee milkCoffee = new MilkDecorator(coffee);

        assertEquals(70, milkCoffee.cost());
        assertEquals("Simple coffee, milk", milkCoffee.description());
    }

    @Test
    void facadeShouldCompleteStudentProcess() {
        StudentPortalFacade facade = new StudentPortalFacade();

        assertEquals("Attendance marked and Fee paid", facade.completeStudentProcess());
    }

    @Test
    void flyweightShouldReuseSameStyleObject() {
        CharacterStyleFactory factory = new CharacterStyleFactory();

        CharacterStyle style1 = factory.getStyle("Arial", 12);
        CharacterStyle style2 = factory.getStyle("Arial", 12);

        assertSame(style1, style2);
        assertEquals("Arial-12", style1.getStyle());
    }

    @Test
    void proxyShouldAllowResultWhenFeePaid() {
        ExamResult result = new ExamResultProxy(true);

        assertEquals("Student result displayed", result.viewResult());
    }

    @Test
    void proxyShouldDenyResultWhenFeeNotPaid() {
        ExamResult result = new ExamResultProxy(false);

        assertEquals("Access denied. Please pay fee.", result.viewResult());
    }
}