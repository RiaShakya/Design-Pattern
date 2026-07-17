package designpatterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Singleton       -> same object should be returned
//Factory         -> correct object should be created
//Observer        -> subscriber should receive notification
//Strategy        -> selected algorithm should work correctly
//Proxy           -> access should be controlled
//Decorator       -> extra behavior should be added
//State           -> object behavior should change with state
// 6. Adapter Pattern
class OldPrinter {
    public String printOldFormat() {
        return "Printing using old printer";
    }
}

interface ModernPrinter {
    String print();
}

class PrinterAdapter implements ModernPrinter {
    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    public String print() {
        return oldPrinter.printOldFormat();
    }
}

// 7. Bridge Pattern
interface MessageSender {
    String sendMessage(String message);
}

class EmailSender implements MessageSender {
    public String sendMessage(String message) {
        return "Email sent: " + message;
    }
}

class SMSSender implements MessageSender {
    public String sendMessage(String message) {
        return "SMS sent: " + message;
    }
}

abstract class Message {
    protected MessageSender sender;

    public Message(MessageSender sender) {
        this.sender = sender;
    }

    abstract String send(String message);
}

class AlertMessage extends Message {
    public AlertMessage(MessageSender sender) {
        super(sender);
    }

    public String send(String message) {
        return sender.sendMessage(message);
    }
}

// 8. Composite Pattern
interface CollegeComponent {
    int getStudentCount();
}

class Department implements CollegeComponent {
    private int studentCount;

    public Department(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getStudentCount() {
        return studentCount;
    }
}

class College implements CollegeComponent {
    private List<CollegeComponent> departments = new ArrayList<>();

    public void addDepartment(CollegeComponent component) {
        departments.add(component);
    }

    public int getStudentCount() {
        int total = 0;
        for (CollegeComponent component : departments) {
            total += component.getStudentCount();
        }
        return total;
    }
}

// 9. Decorator Pattern
interface Coffee {
    double cost();

    String description();
}

class SimpleCoffee implements Coffee {
    public double cost() {
        return 50;
    }

    public String description() {
        return "Simple coffee";
    }
}

class MilkDecorator implements Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public double cost() {
        return coffee.cost() + 20;
    }

    public String description() {
        return coffee.description() + ", milk";
    }
}

// 10. Facade Pattern
class AttendanceService {
    public String markAttendance() {
        return "Attendance marked";
    }
}

class FeeService {
    public String payFee() {
        return "Fee paid";
    }
}

class StudentPortalFacade {
    private AttendanceService attendanceService = new AttendanceService();
    private FeeService feeService = new FeeService();

    public String completeStudentProcess() {
        return attendanceService.markAttendance() + " and " + feeService.payFee();
    }
}

// 11. Flyweight Pattern
class CharacterStyle {
    private String font;
    private int size;

    public CharacterStyle(String font, int size) {
        this.font = font;
        this.size = size;
    }

    public String getStyle() {
        return font + "-" + size;
    }
}

class CharacterStyleFactory {
    private Map<String, CharacterStyle> styles = new HashMap<>();

    public CharacterStyle getStyle(String font, int size) {
        String key = font + size;

        if (!styles.containsKey(key)) {
            styles.put(key, new CharacterStyle(font, size));
        }

        return styles.get(key);
    }
}

// 12. Proxy Pattern
interface ExamResult {
    String viewResult();
}

class RealExamResult implements ExamResult {
    public String viewResult() {
        return "Student result displayed";
    }
}

class ExamResultProxy implements ExamResult {
    private boolean feePaid;
    private RealExamResult realExamResult;

    public ExamResultProxy(boolean feePaid) {
        this.feePaid = feePaid;
        this.realExamResult = new RealExamResult();
    }

    public String viewResult() {
        if (feePaid) {
            return realExamResult.viewResult();
        }
        return "Access denied. Please pay fee.";
    }
}