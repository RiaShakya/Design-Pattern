package practical3;

public class BuilderBadDemo {

    public static void main(String[] args) {

        StudentBad student = new StudentBad(
                101,
                "Ram",
                "ram@gmail.com",
                "9800000000",
                "BCA",
                5,
                "Kathmandu",
                "Hari"
        );

        System.out.println(student);
    }
}