package practical3;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private String phoneNumber;
    private String department;
    private int semester;
    private String address;
    private String guardianName;

    private Student(StudentBuilder builder) {
        this.studentId = builder.studentId;
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.department = builder.department;
        this.semester = builder.semester;
        this.address = builder.address;
        this.guardianName = builder.guardianName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public int getSemester() {
        return semester;
    }

    public String getAddress() {
        return address;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public static class StudentBuilder {

        private int studentId;
        private String name;
        private String email;
        private String phoneNumber;
        private String department;
        private int semester;
        private String address;
        private String guardianName;

        public StudentBuilder setStudentId(int studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public StudentBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public StudentBuilder setSemester(int semester) {
            this.semester = semester;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder setGuardianName(String guardianName) {
            this.guardianName = guardianName;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
