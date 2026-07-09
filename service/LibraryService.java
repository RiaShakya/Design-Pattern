package LibraryManagement.service;

/*
 * DIP (Dependency Inversion Principle)
 * High-level modules depend on this abstraction
 * instead of a concrete implementation.
 */

public interface LibraryService {

    // ---------------- Book Operations ----------------

    void addBook();

    void viewAllBooks();

    void searchBook();

    void updateBook();

    void deleteBook();

    // ---------------- Member Operations ----------------

    void registerMember();

    void viewAllMembers();

    void searchMember();

    void updateMember();

    void deleteMember();

    // ---------------- Borrow Operations ----------------

    void issueBook();

    void returnBook();

    void viewBorrowRecords();

    void viewMemberBorrowHistory();

}