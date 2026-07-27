package practical6.GoodDesign;

public class StudentMarks implements StudentRecord {

    @Override
    public void viewMarks() {

        System.out.println("Student Marks");
        System.out.println("Math: 90");
        System.out.println("Science: 88");

    }

}
