package practical6.GoodDesign;

public class StudentRecordProxy implements StudentRecord {

    private final String role;
    private final StudentMarks studentMarks;

    public StudentRecordProxy(String role) {

        this.role = role;
        this.studentMarks = new StudentMarks();

    }

    @Override
    public void viewMarks() {

        if ("ADMIN".equalsIgnoreCase(role)) {

            studentMarks.viewMarks();

        } else {

            System.out.println("Access Denied");

        }

    }

}