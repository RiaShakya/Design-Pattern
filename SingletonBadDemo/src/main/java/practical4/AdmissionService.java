package practical4;

import practical1.CollegeConfig;
import practical2.Notification;
import practical2.NotificationFactory;
import practical3.Student;

import java.util.Scanner;

public class AdmissionService {

    public void admitStudent() {

        Scanner scanner = new Scanner(System.in);

        // Load College Configuration (Singleton)
        CollegeConfig config = CollegeConfig.getInstance();

        System.out.println("===== PCPS Admission System =====");
        System.out.println("College: " + config.getCollegeName());
        System.out.println("System Version: " + config.getSystemVersion());

        System.out.println("\n----- Student Admission Form -----");

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Semester: ");
        int semester = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Guardian Name: ");
        String guardian = scanner.nextLine();

        // Create Student using Builder
        Student student = new Student.StudentBuilder()
                .setStudentId(id)
                .setName(name)
                .setEmail(email)
                .setPhoneNumber(phone)
                .setDepartment(department)
                .setSemester(semester)
                .setAddress(address)
                .setGuardianName(guardian)
                .build();

        // Display Student Details
        System.out.println("\n===== Student Profile =====");
        System.out.println("Student ID : " + student.getStudentId());
        System.out.println("Name       : " + student.getName());
        System.out.println("Email      : " + student.getEmail());
        System.out.println("Phone      : " + student.getPhoneNumber());
        System.out.println("Department : " + student.getDepartment());
        System.out.println("Semester   : " + student.getSemester());
        System.out.println("Address    : " + student.getAddress());
        System.out.println("Guardian   : " + student.getGuardianName());

        // Choose Notification Type
        System.out.print("\nEnter Notification Type (EMAIL/SMS/PUSH): ");
        String type = scanner.nextLine();

        Notification notification =
                NotificationFactory.createNotification(type);

        notification.send("Welcome " + student.getName()
                + "! Your admission has been confirmed.");

        System.out.println("\nAdmission Completed Successfully.");

        scanner.close();
    }
}