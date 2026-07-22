package practical6.BadDesign;

public class Main {

    public static void main(String[] args) {

        StudentMarks studentMarks = new StudentMarks();

        // Anyone can view marks
        studentMarks.viewMarks();

    }

}