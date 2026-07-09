package LibraryManagement.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import LibraryManagement.model.Book;
import LibraryManagement.model.BorrowRecord;
import LibraryManagement.model.Member;

/*
 * SRP:
 * This class is responsible only for managing
 * borrowing and returning books.
 *
 * Association:
 * Connects Member and Book through BorrowRecord.
 */

public class BorrowRepository {

    private List<BorrowRecord> borrowRecords;
    private BookRepository bookRepository;
    private MemberRepository memberRepository;

    public BorrowRepository(BookRepository bookRepository,
                            MemberRepository memberRepository) {

        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.borrowRecords = new ArrayList<>();
    }

    // Issue Book

    public boolean issueBook(int borrowId, int bookId, int memberId) {

        Book book = bookRepository.searchBookById(bookId);
        Member member = memberRepository.searchMemberById(memberId);

        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already issued.");
            return false;
        }

        book.setAvailable(false);

        BorrowRecord record = new BorrowRecord(
                borrowId,
                book,
                member,
                LocalDate.now(),
                null);

        borrowRecords.add(record);

        System.out.println("Book issued successfully.");

        return true;
    }

    // Return Book

    public boolean returnBook(int bookId) {

        for (BorrowRecord record : borrowRecords) {

            if (record.getBook().getBookId() == bookId &&
                record.getReturnDate() == null) {

                record.setReturnDate(LocalDate.now());

                record.getBook().setAvailable(true);

                System.out.println("Book returned successfully.");

                return true;
            }
        }

        System.out.println("Borrow record not found.");

        return false;
    }

    // Search Borrow Record

    public BorrowRecord searchBorrowRecord(int borrowId) {

        for (BorrowRecord record : borrowRecords) {

            if (record.getBorrowId() == borrowId) {
                return record;
            }

        }

        return null;
    }

    // Get All Records

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecords;
    }

    // Display Borrow Records

    public void displayBorrowRecords() {

        if (borrowRecords.isEmpty()) {

            System.out.println("No borrow records found.");

            return;
        }

        for (BorrowRecord record : borrowRecords) {

            System.out.println("--------------------------------");
            System.out.println("Borrow ID : " + record.getBorrowId());
            System.out.println("Book      : " + record.getBook().getTitle());
            System.out.println("Member    : " + record.getMember().getName());
            System.out.println("Issue Date: " + record.getIssueDate());

            if (record.getReturnDate() == null) {
                System.out.println("Return Date : Not Returned");
            } else {
                System.out.println("Return Date : " + record.getReturnDate());
            }

            System.out.println("--------------------------------");
        }
    }

    // Display Books Borrowed by a Member

    public void displayMemberBorrowHistory(int memberId) {

        boolean found = false;

        for (BorrowRecord record : borrowRecords) {

            if (record.getMember().getId() == memberId) {

                found = true;

                System.out.println("--------------------------------");
                System.out.println("Borrow ID : " + record.getBorrowId());
                System.out.println("Book      : " + record.getBook().getTitle());
                System.out.println("Issue Date: " + record.getIssueDate());

                if (record.getReturnDate() == null) {
                    System.out.println("Status    : Borrowed");
                } else {
                    System.out.println("Returned  : " + record.getReturnDate());
                }

            }

        }

        if (!found) {
            System.out.println("No borrow history found.");
        }

    }

    // Delete Borrow Record

    public boolean deleteBorrowRecord(int borrowId) {

        BorrowRecord record = searchBorrowRecord(borrowId);

        if (record != null) {

            borrowRecords.remove(record);

            return true;
        }

        return false;
    }

}