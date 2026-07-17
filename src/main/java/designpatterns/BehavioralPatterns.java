package designpatterns;

import java.util.ArrayList;
import java.util.List;

//Singleton       -> same object should be returned
//Factory         -> correct object should be created
//Observer        -> subscriber should receive notification
//Strategy        -> selected algorithm should work correctly
//Proxy           -> access should be controlled
//Decorator       -> extra behavior should be added
//State           -> object behavior should change with state

// 13. Chain of Responsibility Pattern
abstract class LeaveApprover {
    protected LeaveApprover nextApprover;

    public void setNextApprover(LeaveApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    abstract String approveLeave(int days);
}

class ClassTeacher extends LeaveApprover {
    public String approveLeave(int days) {
        if (days <= 2) {
            return "Leave approved by Class Teacher";
        }
        return nextApprover.approveLeave(days);
    }
}

class HOD extends LeaveApprover {
    public String approveLeave(int days) {
        if (days <= 5) {
            return "Leave approved by HOD";
        }
        return "Leave requires Principal approval";
    }
}

// 14. Command Pattern
interface Command {
    String execute();
}

class Light {
    public String turnOn() {
        return "Light turned on";
    }
}

class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    public String execute() {
        return light.turnOn();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public String pressButton() {
        return command.execute();
    }
}

// 15. Interpreter Pattern
interface Expression {
    boolean interpret(String context);
}

class ContainsExpression implements Expression {
    private String word;

    public ContainsExpression(String word) {
        this.word = word;
    }

    public boolean interpret(String context) {
        return context.contains(word);
    }
}

// 16. Iterator Pattern
class StudentCollection {
    private List<String> students = new ArrayList<>();

    public void addStudent(String name) {
        students.add(name);
    }

    public StudentIterator iterator() {
        return new StudentIterator(students);
    }
}

class StudentIterator {
    private List<String> students;
    private int index = 0;

    public StudentIterator(List<String> students) {
        this.students = students;
    }

    public boolean hasNext() {
        return index < students.size();
    }

    public String next() {
        return students.get(index++);
    }
}

// 17. Mediator Pattern
class ChatRoom {
    public String showMessage(String user, String message) {
        return user + ": " + message;
    }
}

class ChatUser {
    private String name;
    private ChatRoom chatRoom;

    public ChatUser(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String sendMessage(String message) {
        return chatRoom.showMessage(name, message);
    }
}

// 18. Memento Pattern
class TextEditorMemento {
    private String content;

    public TextEditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class TextEditor {
    private String content;

    public void write(String content) {
        this.content = content;
    }

    public TextEditorMemento save() {
        return new TextEditorMemento(content);
    }

    public void restore(TextEditorMemento memento) {
        this.content = memento.getContent();
    }

    public String getContent() {
        return content;
    }
}

// 19. Observer Pattern
interface Observer {
    void update(String message);
}

class StudentObserver implements Observer {
    private String notification;

    public void update(String message) {
        this.notification = message;
    }

    public String getNotification() {
        return notification;
    }
}

class NoticeBoard {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void publishNotice(String notice) {
        for (Observer observer : observers) {
            observer.update(notice);
        }
    }
}

// 20. State Pattern
interface OrderState {
    String handle();
}

class NewOrderState implements OrderState {
    public String handle() {
        return "Order is new";
    }
}

class DeliveredOrderState implements OrderState {
    public String handle() {
        return "Order is delivered";
    }
}

class Order {
    private OrderState state;

    public void setState(OrderState state) {
        this.state = state;
    }

    public String getStatus() {
        return state.handle();
    }
}

// 21. Strategy Pattern
interface GradingStrategy {
    String grade(int marks);
}

class NormalGrading implements GradingStrategy {
    public String grade(int marks) {
        return marks >= 40 ? "Pass" : "Fail";
    }
}

class GraceGrading implements GradingStrategy {
    public String grade(int marks) {
        return marks >= 35 ? "Pass with grace" : "Fail";
    }
}

class ExamResultContext {
    private GradingStrategy strategy;

    public ExamResultContext(GradingStrategy strategy) {
        this.strategy = strategy;
    }

    public String calculateGrade(int marks) {
        return strategy.grade(marks);
    }
}

// 22. Template Method Pattern
abstract class OnlineExam {
    public final String conductExam() {
        return login() + " -> " + startExam() + " -> " + submitExam();
    }

    String login() {
        return "Student logged in";
    }

    abstract String startExam();

    String submitExam() {
        return "Exam submitted";
    }
}

class JavaOnlineExam extends OnlineExam {
    String startExam() {
        return "Java exam started";
    }
}

// 23. Visitor Pattern
interface CollegeVisitor {
    String visit(Library library);

    String visit(Lab lab);
}

interface CollegePlace {
    String accept(CollegeVisitor visitor);
}

class Library implements CollegePlace {
    public String accept(CollegeVisitor visitor) {
        return visitor.visit(this);
    }
}

class Lab implements CollegePlace {
    public String accept(CollegeVisitor visitor) {
        return visitor.visit(this);
    }
}

class MaintenanceVisitor implements CollegeVisitor {
    public String visit(Library library) {
        return "Maintaining library";
    }

    public String visit(Lab lab) {
        return "Maintaining lab";
    }
}