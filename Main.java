package LibraryManagement;

import java.util.Scanner;

import LibraryManagement.service.LibraryService;
import LibraryManagement.service.LibraryServiceImpl;

/*
 * Library Management System
 *
 * OOP Concepts:
 * - Classes & Objects
 * - Encapsulation
 * - Inheritance
 * - Polymorphism
 * - Abstraction
 *
 * SOLID:
 * - DIP: Main depends on the LibraryService interface,
 *   not the implementation.
 */

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // DIP: Depend on abstraction
        LibraryService libraryService = new LibraryServiceImpl();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("   LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Register Member");
            System.out.println("7. View All Members");
            System.out.println("8. Search Member");
            System.out.println("9. Update Member");
            System.out.println("10. Delete Member");
            System.out.println("11. Issue Book");
            System.out.println("12. Return Book");
            System.out.println("13. View Borrow Records");
            System.out.println("14. View Member Borrow History");
            System.out.println("0. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    libraryService.addBook();
                    break;

                case 2:
                    libraryService.viewAllBooks();
                    break;

                case 3:
                    libraryService.searchBook();
                    break;

                case 4:
                    libraryService.updateBook();
                    break;

                case 5:
                    libraryService.deleteBook();
                    break;

                case 6:
                    libraryService.registerMember();
                    break;

                case 7:
                    libraryService.viewAllMembers();
                    break;

                case 8:
                    libraryService.searchMember();
                    break;

                case 9:
                    libraryService.updateMember();
                    break;

                case 10:
                    libraryService.deleteMember();
                    break;

                case 11:
                    libraryService.issueBook();
                    break;

                case 12:
                    libraryService.returnBook();
                    break;

                case 13:
                    libraryService.viewBorrowRecords();
                    break;

                case 14:
                    libraryService.viewMemberBorrowHistory();
                    break;

                case 0:
                    System.out.println("Thank you for using the Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}