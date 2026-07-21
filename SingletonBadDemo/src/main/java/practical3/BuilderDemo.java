package practical3;

public class BuilderDemo {

    public static void main(String[] args) {

        Student student = new Student.StudentBuilder()
                .setStudentId(101)
                .setName("Ram")
                .setEmail("ram@gmail.com")
                .setPhoneNumber("9800000000")
                .setDepartment("BCA")
                .setSemester(5)
                .setAddress("Kathmandu")
                .setGuardianName("Hari")
                .build();

        System.out.println(student.getName());
        System.out.println(student.getDepartment());
    }
}