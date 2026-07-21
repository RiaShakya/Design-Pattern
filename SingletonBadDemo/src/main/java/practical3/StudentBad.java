package practical3;

public class StudentBad {

    private int studentId;
    private String name;
    private String email;
    private String phoneNumber;
    private String department;
    private int semester;
    private String address;
    private String guardianName;

    public StudentBad(
            int studentId,
            String name,
            String email,
            String phoneNumber,
            String department,
            int semester,
            String address,
            String guardianName) {

        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.semester = semester;
        this.address = address;
        this.guardianName = guardianName;
    }
}
