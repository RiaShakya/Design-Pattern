package LibraryManagement.service;

import java.util.List;
import java.util.Scanner;

import LibraryManagement.model.Book;
import LibraryManagement.repository.BookRepository;
import LibraryManagement.repository.BorrowRepository;
import LibraryManagement.repository.MemberRepository;

/*
 * SRP:
 * Handles library operations by coordinating repositories.
 *
 * DIP:
 * Implements the LibraryService interface instead of being
 * accessed directly by the Main class.
 */

public class LibraryServiceImpl implements LibraryService {

    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private BorrowRepository borrowRepository;

    private Scanner sc;

    public LibraryServiceImpl() {

        bookRepository = new BookRepository();
        memberRepository = new MemberRepository();
        borrowRepository = new BorrowRepository(bookRepository, memberRepository);

        sc = new Scanner(System.in);
    }

    // =========================
    // BOOK OPERATIONS
    // =========================

    @Override
    public void addBook() {

        System.out.println("\n===== Add Book =====");

        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        Book book = new Book(id, title, author, category, true);

        bookRepository.addBook(book);

    }

    @Override
    public void viewAllBooks() {

        System.out.println("\n===== Book List =====");

        bookRepository.displayBooks();

    }

    @Override
    public void searchBook() {

        System.out.print("Enter Book Title: ");

        sc.nextLine();
        String title = sc.nextLine();

        List<Book> books = bookRepository.searchBookByTitle(title);

        if (books.isEmpty()) {

            System.out.println("No books found.");

            return;
        }

        for (Book book : books) {

            System.out.println("----------------------");
            System.out.println(book);
        }
    }

    @Override
    public void updateBook() {

        System.out.print("Book ID: ");

        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("New Title: ");
        String title = sc.nextLine();

        System.out.print("New Author: ");
        String author = sc.nextLine();

        System.out.print("New Category: ");
        String category = sc.nextLine();

        System.out.print("Available (true/false): ");
        boolean available = sc.nextBoolean();

        boolean updated = bookRepository.updateBook(
                id,
                title,
                author,
                category,
                available);

        if (updated) {

            System.out.println("Book updated successfully.");

        } else {

            System.out.println("Book not found.");
        }
    }
    @Override
    public void deleteBook() {

        System.out.print("Book ID: ");

        int id = sc.nextInt();

        boolean deleted = bookRepository.deleteBook(id);

        if (deleted) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
    
    // =========================
    // MEMBER OPERATIONS
    // =========================

    @Override
    public void registerMember() {

        System.out.println("\n===== Register Member =====");

        System.out.print("Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        memberRepository.addMember(
                new LibraryManagement.model.Member(id, name, email, phone));

    }

    @Override
    public void viewAllMembers() {

        System.out.println("\n===== Member List =====");

        memberRepository.displayMembers();

    }

    @Override
    public void searchMember() {

        System.out.print("Enter Member ID: ");

        int id = sc.nextInt();

        LibraryManagement.model.Member member =
                memberRepository.searchMemberById(id);

        if (member == null) {

            System.out.println("Member not found.");

            return;
        }

        member.displayInfo();

    }

    @Override
    public void updateMember() {

        System.out.print("Member ID: ");

        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("New Name: ");
        String name = sc.nextLine();

        System.out.print("New Email: ");
        String email = sc.nextLine();

        System.out.print("New Phone: ");
        String phone = sc.nextLine();

        boolean updated =
                memberRepository.updateMember(id, name, email, phone);

        if (updated) {

            System.out.println("Member updated successfully.");

        } else {

            System.out.println("Member not found.");

        }

    }

    @Override
    public void deleteMember() {

        System.out.print("Member ID: ");

        int id = sc.nextInt();

        boolean deleted = memberRepository.deleteMember(id);

        if (deleted) {

            System.out.println("Member deleted successfully.");

        } else {

            System.out.println("Member not found.");

        }

    }

    // =========================
    // BORROW OPERATIONS
    // =========================

    @Override
    public void issueBook() {

        System.out.print("Borrow ID: ");
        int borrowId = sc.nextInt();

        System.out.print("Book ID: ");
        int bookId = sc.nextInt();

        System.out.print("Member ID: ");
        int memberId = sc.nextInt();

        borrowRepository.issueBook(
                borrowId,
                bookId,
                memberId);

    }

    @Override
    public void returnBook() {

        System.out.print("Book ID: ");

        int bookId = sc.nextInt();

        borrowRepository.returnBook(bookId);

    }

    @Override
    public void viewBorrowRecords() {

        System.out.println("\n===== Borrow Records =====");

        borrowRepository.displayBorrowRecords();

    }

    @Override
    public void viewMemberBorrowHistory() {

        System.out.print("Member ID: ");

        int memberId = sc.nextInt();

        borrowRepository.displayMemberBorrowHistory(memberId);

    }

}   