import builder.Member;
import service.LibraryRegistration;
import service.BorrowBook;
import service.LibraryWorkflow;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=======================================================");
        System.out.println("        LIBRARY MANAGEMENT SYSTEM");
        System.out.println("      DESIGN PATTERNS INTEGRATED PROJECT");
        System.out.println("=======================================================");

        // ===============================
        // MEMBER REGISTRATION
        // ===============================

        System.out.println("\nEnter Member Details");

        System.out.print("Member ID : ");
        String id = sc.nextLine();

        System.out.print("Member Name : ");
        String name = sc.nextLine();

        System.out.print("Email : ");
        String email = sc.nextLine();

        System.out.print("Phone : ");
        String phone = sc.nextLine();

        System.out.print("Address : ");
        String address = sc.nextLine();

        // ===============================
        // FACTORY METHOD INPUT
        // ===============================

        System.out.println("\nChoose Welcome Notification");

        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.println("3. Push");

        System.out.print("Choice : ");

        int notificationChoice = sc.nextInt();

        String notificationType;

        switch (notificationChoice) {

            case 1:
                notificationType = "email";
                break;

            case 2:
                notificationType = "sms";
                break;

            case 3:
                notificationType = "push";
                break;

            default:
                notificationType = "email";
        }

        sc.nextLine();

        // ===============================
        // BUILDER PATTERN
        // ===============================

        Member member = new Member.MemberBuilder()
                .setMemberId(id)
                .setName(name)
                .setEmail(email)
                .setPhone(phone)
                .setAddress(address)
                .build();

        // ===============================
        // CREATIONAL PATTERNS
        // Singleton + Builder + Factory
        // ===============================

        LibraryRegistration registration = new LibraryRegistration();

        registration.register(member, notificationType);

        // ===============================
        // STRUCTURAL PATTERNS
        // ===============================

        System.out.println("\nEnter Book Details");

        System.out.print("Book Name : ");
        String book = sc.nextLine();

        System.out.println("\nLogin Role");

        System.out.println("1. Librarian");
        System.out.println("2. Member");

        System.out.print("Choice : ");

        int roleChoice = sc.nextInt();

        String role;

        if (roleChoice == 1)
            role = "LIBRARIAN";
        else
            role = "MEMBER";

        BorrowBook borrowBook = new BorrowBook();

        borrowBook.process(
                member.getName(),
                book,
                role
        );

        // ===============================
        // BEHAVIORAL PATTERNS
        // ===============================

        System.out.println("\nFine Payment");

        System.out.print("Enter Fine Amount : NPR ");
        double amount = sc.nextDouble();

        System.out.println("\nSelect Payment Method");

        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. eSewa");

        System.out.print("Choice : ");

        int paymentChoice = sc.nextInt();

        String paymentMethod;

        switch (paymentChoice) {

            case 1:
                paymentMethod = "cash";
                break;

            case 2:
                paymentMethod = "card";
                break;

            case 3:
                paymentMethod = "esewa";
                break;

            default:
                paymentMethod = "cash";
        }

        LibraryWorkflow workflow = new LibraryWorkflow();

        workflow.process(amount, paymentMethod);

        sc.close();
    }
}