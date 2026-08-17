import builder.Member;
import proxy.LibraryProxy;
import service.AdminService;
import service.BorrowBook;
import service.InputHelper;
import service.LibrarianService;
import service.LibraryRegistration;
import service.LibraryWorkflow;
import service.LoginService;
import service.MemberService;
import singleton.LibraryConfig;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Singleton config is shown once, at system startup.
        LibraryConfig.getInstance().printConfig();

        LoginService loginService = new LoginService();
        AdminService adminService = new AdminService();
        LibrarianService librarianService = new LibrarianService();

        while (true) {

            System.out.println("\n=======================================================");
            System.out.println("           LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=======================================================");
            System.out.println("Login As?");
            System.out.println("1. Admin");
            System.out.println("2. Librarian");
            System.out.println("3. Member");
            System.out.println("4. Exit");

            int choice = InputHelper.readInt(sc, "\nEnter Choice : ");

            switch (choice) {

                case 1:

                    if (loginService.adminLogin()) {

                        grantAccess("ADMIN");

                        adminService.showMenu();

                    }

                    break;

                case 2:

                    if (loginService.librarianLogin()) {

                        grantAccess("LIBRARIAN");

                        librarianService.showMenu();

                    }

                    break;

                case 3:

                    memberMenu();

                    break;

                case 4:

                    System.out.println("\nThank you for using the Library Management System.");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

    // ==========================================
    // PROXY PATTERN - ACCESS CONTROL AT LOGIN
    // ==========================================

    private static void grantAccess(String role) {

        System.out.println();
        System.out.println("======================================");
        System.out.println("PROXY PATTERN");
        System.out.println("======================================");

        LibraryProxy proxy = new LibraryProxy(role);

        proxy.accessRecord();

    }

    // ==========================================
    // MEMBER MENU
    // ==========================================

    private static void memberMenu() {

        while (true) {

            System.out.println("\n============== MEMBER ==============");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Back");

            int choice = InputHelper.readInt(sc, "Enter Choice : ");

            switch (choice) {

                case 1:

                    registerMember();
                    break;

                case 2:

                    LoginService loginService = new LoginService();

                    if (loginService.memberLogin()) {

                        grantAccess("MEMBER");

                        memberOperations();

                    }

                    break;

                case 3:

                    return;

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

    // ==========================================
    // MEMBER REGISTRATION
    // ==========================================

    private static void registerMember() {

        System.out.println("\n=========== MEMBER REGISTRATION ===========");

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

        System.out.println("\nChoose Welcome Notification");

        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.println("3. Push");

        int notificationChoice =
                InputHelper.readInt(sc, "Choice : ");

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

        Member member = new Member.MemberBuilder()
                .setMemberId(id)
                .setName(name)
                .setEmail(email)
                .setPhone(phone)
                .setAddress(address)
                .build();

        LibraryRegistration registration =
                new LibraryRegistration();

        registration.register(member, notificationType);

    }

    // ==========================================
    // MEMBER OPERATIONS
    // ==========================================

    private static void memberOperations() {

        MemberService memberService = new MemberService();

        while (true) {

            System.out.println("\n============= MEMBER MENU =============");

            System.out.println("1. View All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. My Borrow History");
            System.out.println("6. Pay Fine");
            System.out.println("7. My Payment History");
            System.out.println("8. My Notifications");
            System.out.println("9. Logout");

            int choice =
                    InputHelper.readInt(sc, "Enter Choice : ");

            switch (choice) {

                case 1:

                    memberService.viewAllBooks();

                    break;

                case 2:

                    System.out.print("\nSearch by Title/Author : ");

                    String keyword = sc.nextLine();

                    memberService.searchBooks(keyword);

                    break;

                case 3:

                    borrowBook();

                    break;

                case 4:

                    returnBook(memberService);

                    break;

                case 5:

                    memberService.viewBorrowHistory(
                            LoginService.getLoggedInMemberCode());

                    break;

                case 6:

                    payFine(memberService);

                    break;

                case 7:

                    memberService.viewPaymentHistory(
                            LoginService.getLoggedInMemberCode());

                    break;

                case 8:

                    memberService.viewMyNotifications(
                            LoginService.getLoggedInMemberCode());

                    break;

                case 9:

                    return;

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

    // ==========================================
    // BORROW BOOK
    // ==========================================
// ==========================================
// BORROW BOOK
// ==========================================

    // ==========================================
// BORROW BOOK
// ==========================================

    private static void borrowBook() {

        String memberCode =
                LoginService.getLoggedInMemberCode();

        System.out.println("\nMember Code : " + memberCode);

        System.out.print("Enter Book Title : ");

        String book = sc.nextLine();

        BorrowBook borrow = new BorrowBook();

        borrow.process(
                memberCode,
                book,
                "MEMBER"
        );

    }

    // ==========================================
    // RETURN BOOK
    // ==========================================

    private static void returnBook(MemberService memberService) {

        String memberCode =
                LoginService.getLoggedInMemberCode();

        System.out.println("\nMember Code : " + memberCode);

        int bookId =
                InputHelper.readInt(sc, "Enter Book ID : ");

        memberService.returnBook(memberCode, bookId);

    }

    // ==========================================
    // FINE PAYMENT
    // ==========================================

    private static void payFine(MemberService memberService) {

        String memberCode =
                LoginService.getLoggedInMemberCode();

        System.out.println("\nMember Code : " + memberCode);

        // Fine is calculated automatically: NPR 50/day, per overdue book.
        double dueFine = memberService.calculateFine(memberCode);

        if (dueFine <= 0) {

            System.out.println("You have no overdue books. No fine is due at this time.");
            return;

        }

        System.out.println("Fine Due : NPR " + String.format("%.2f", dueFine)
                + "  (NPR 50/day, per overdue book)");

        double amount;

        while (true) {

            amount = InputHelper.readDouble(sc, "Enter Fine Amount : NPR ");

            // The amount entered must exactly match the calculated fine.
            if (Math.abs(amount - dueFine) < 0.01) {

                break;

            }

            System.out.println("Entered amount (NPR " + String.format("%.2f", amount)
                    + ") does not match the fine due (NPR " + String.format("%.2f", dueFine)
                    + "). Please enter the exact amount.");

        }

        System.out.println("\nChoose Payment Method");

        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. eSewa");

        int paymentChoice =
                InputHelper.readInt(sc, "Choice : ");

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

        LibraryWorkflow workflow =
                new LibraryWorkflow();

        workflow.process(
                "MEMBER",
                memberCode,
                amount,
                paymentMethod
        );

    }
}