package practical4;

import practical1.CollegeConfig;
import practical2.Notification;
import practical2.NotificationFactory;
import practical3.Student;

public class AdmissionService {

    public void admitStudent() {

        // Load college configuration (Singleton)
        CollegeConfig config = CollegeConfig.getInstance();

        System.out.println("===== PCPS Admission System =====");
        System.out.println("College : " + config.getCollegeName());
        System.out.println("Version : " + config.getSystemVersion());

        // Create Student (Builder)
        Student student = new Student.StudentBuilder()
                .setStudentId(101)
                .setName("Ria Shakya")
                .setEmail("ria@gmail.com")
                .setPhoneNumber("9800000000")
                .setDepartment("BIT")
                .setSemester(1)
                .setAddress("Kathmandu")
                .setGuardianName("Hari Shakya")
                .build();

        System.out.println("\nStudent Profile Created");
        System.out.println("Name: " + student.getName());
        System.out.println("Department: " + student.getDepartment());
        System.out.println("Semester: " + student.getSemester());

        // Send Notification (Factory)
        Notification notification =
                NotificationFactory.createNotification("EMAIL");

        notification.send("Welcome " + student.getName()
                + "! Your admission has been confirmed.");

        System.out.println("\nAdmission Completed Successfully.");
    }
}