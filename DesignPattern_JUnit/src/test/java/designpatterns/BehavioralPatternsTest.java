package designpatterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BehavioralPatternsTest {

    @Test
    void chainShouldApproveLeaveByClassTeacher() {
        LeaveApprover teacher = new ClassTeacher();
        LeaveApprover hod = new HOD();
        teacher.setNextApprover(hod);

        assertEquals("Leave approved by Class Teacher", teacher.approveLeave(2));
    }

    @Test
    void chainShouldApproveLeaveByHOD() {
        LeaveApprover teacher = new ClassTeacher();
        LeaveApprover hod = new HOD();
        teacher.setNextApprover(hod);

        assertEquals("Leave approved by HOD", teacher.approveLeave(4));
    }

    @Test
    void commandShouldTurnOnLight() {
        Light light = new Light();
        Command command = new TurnOnLightCommand(light);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(command);

        assertEquals("Light turned on", remoteControl.pressButton());
    }

    @Test
    void interpreterShouldCheckWordInSentence() {
        Expression expression = new ContainsExpression("Java");

        assertTrue(expression.interpret("I am learning Java"));
        assertFalse(expression.interpret("I am learning Python"));
    }

    @Test
    void iteratorShouldIterateStudents() {
        StudentCollection collection = new StudentCollection();
        collection.addStudent("Ram");
        collection.addStudent("Sita");

        StudentIterator iterator = collection.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Ram", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Sita", iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    void mediatorShouldSendMessageThroughChatRoom() {
        ChatRoom chatRoom = new ChatRoom();
        ChatUser user = new ChatUser("Ram", chatRoom);

        assertEquals("Ram: Hello", user.sendMessage("Hello"));
    }

    @Test
    void mementoShouldRestoreOldContent() {
        TextEditor editor = new TextEditor();

        editor.write("Version 1");
        TextEditorMemento saved = editor.save();

        editor.write("Version 2");
        editor.restore(saved);

        assertEquals("Version 1", editor.getContent());
    }

    @Test
    void observerShouldReceiveNotification() {
        NoticeBoard noticeBoard = new NoticeBoard();
        StudentObserver student = new StudentObserver();

        noticeBoard.addObserver(student);
        noticeBoard.publishNotice("Exam tomorrow");

        assertEquals("Exam tomorrow", student.getNotification());
    }

    @Test
    void stateShouldChangeOrderStatus() {
        Order order = new Order();

        order.setState(new NewOrderState());
        assertEquals("Order is new", order.getStatus());

        order.setState(new DeliveredOrderState());
        assertEquals("Order is delivered", order.getStatus());
    }

    @Test
    void strategyShouldUseNormalGrading() {
        ExamResultContext context = new ExamResultContext(new NormalGrading());

        assertEquals("Pass", context.calculateGrade(45));
        assertEquals("Fail", context.calculateGrade(30));
    }

    @Test
    void strategyShouldUseGraceGrading() {
        ExamResultContext context = new ExamResultContext(new GraceGrading());

        assertEquals("Pass with grace", context.calculateGrade(35));
        assertEquals("Fail", context.calculateGrade(30));
    }

    @Test
    void templateMethodShouldConductJavaExam() {
        OnlineExam exam = new JavaOnlineExam();

        assertEquals(
                "Student logged in -> Java exam started -> Exam submitted",
                exam.conductExam()
        );
    }

    @Test
    void visitorShouldVisitLibraryAndLab() {
        CollegeVisitor visitor = new MaintenanceVisitor();

        CollegePlace library = new Library();
        CollegePlace lab = new Lab();

        assertEquals("Maintaining library", library.accept(visitor));
        assertEquals("Maintaining lab", lab.accept(visitor));
    }
}