package org.example;

import practical4.GoodDesign.EmailAdapter;
import practical4.GoodDesign.LegacyEmailService;
import practical4.GoodDesign.NotificationService;
import practical4.GoodDesign.NotificationSystem;

import practical5.GoodDesign.StudentRegistrationFacade;

import practical6.GoodDesign.StudentRecord;
import practical6.GoodDesign.StudentRecordProxy;

import practical7.GoodDesign.*;

import practical8.GoodDesign.*;

import practical9.GoodDesign.*;

import practical10.GoodDesign.*;

import practical11.GoodDesign.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println(" PCPS STUDENT ACADEMIC MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        // ------------------ Facade ------------------
        System.out.println("\nFACADE PATTERN");

        System.out.print("\nEnter Student Name: ");
        String name = sc.nextLine();

        StudentRegistrationFacade facade = new StudentRegistrationFacade();
        facade.registerStudent(name);

        // ------------------ Adapter ------------------
        System.out.println("\nADAPTER PATTERN");

        System.out.print("\nEnter Welcome Message: ");
        String message = sc.nextLine();

        NotificationService service =
                new EmailAdapter(new LegacyEmailService());

        NotificationSystem notification =
                new NotificationSystem(service);

        notification.notifyStudent(message);

        // ------------------ Proxy ------------------
        System.out.println("\nPROXY PATTERN");

        System.out.print("\nEnter Role (ADMIN/STUDENT): ");
        String role = sc.nextLine();

        StudentRecord record = new StudentRecordProxy(role);

        System.out.println("\n===== Student Record =====");
        record.viewMarks();

        // ------------------ Decorator ------------------
        System.out.println("\nDECORATOR PATTERN");

        Report report = new StudentReport();

        System.out.print("\nAdd PDF? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            report = new PdfDecorator(report);
        }

        System.out.print("Add Watermark? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            report = new WatermarkDecorator(report);
        }

        System.out.print("Add Signature? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            report = new SignatureDecorator(report);
        }

        System.out.println("\n===== Generated Report =====");
        report.generate();

        // ------------------ Strategy ------------------
        System.out.println("\nSTRATEGY PATTERN");

        PaymentContext payment = new PaymentContext();

        System.out.print("\nEnter Fee Amount: ");
        double amount = sc.nextDouble();

        System.out.println("\nSelect Payment Method");
        System.out.println("1. Khalti");
        System.out.println("2. eSewa");
        System.out.println("3. Bank Transfer");

        System.out.print("Choice: ");
        int paymentChoice = sc.nextInt();
        sc.nextLine();

        switch (paymentChoice) {

            case 1:
                payment.setPaymentStrategy(new KhaltiPayment());
                break;

            case 2:
                payment.setPaymentStrategy(new EsewaPayment());
                break;

            case 3:
                payment.setPaymentStrategy(new BankTransferPayment());
                break;

            default:
                System.out.println("Invalid Choice");
                return;
        }

        payment.makePayment(amount);

        // ------------------ Observer ------------------
        ResultPublisher publisher = new ResultPublisher();

        publisher.addObserver(new StudentObserver());
        publisher.addObserver(new ParentObserver());
        publisher.addObserver(new DepartmentObserver());

        System.out.println("\n===== Result Notification =====");
        publisher.publishResult();

        // ------------------ Command ------------------
        StudentPortal portal = new StudentPortal();

        System.out.println("\nStudent Service Requests");
        System.out.println("1. Transcript");
        System.out.println("2. Certificate");
        System.out.println("3. ID Card");
        System.out.println("4. Library Card");

        System.out.print("Choice: ");
        int request = sc.nextInt();

        switch (request) {

            case 1:
                portal.setCommand(new TranscriptRequest());
                break;

            case 2:
                portal.setCommand(new CertificateRequest());
                break;

            case 3:
                portal.setCommand(new IDCardRequest());
                break;

            case 4:
                portal.setCommand(new LibraryCardRequest());
                break;

            default:
                System.out.println("Invalid Choice");
                return;
        }

        System.out.println();
        portal.submitRequest();

        // ------------------ State ------------------
        AdmissionApplication application =
                new AdmissionApplication();

        System.out.println("\n===== Admission Status =====");

        application.showStatus();

        application.nextState();
        application.showStatus();

        application.nextState();
        application.showStatus();

        application.nextState();
        application.showStatus();

        // ------------------ Summary ------------------
        System.out.println("\n==============================================");
        System.out.println("Student Name : " + name);
        System.out.println("Role         : " + role);
        System.out.println("Fee Paid     : Rs. " + amount);
        System.out.println("==============================================");

        sc.close();
    }
}