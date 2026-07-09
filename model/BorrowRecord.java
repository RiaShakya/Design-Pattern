package LibraryManagement.model;

import java.time.LocalDate;

/*
 * Composition:
 * BorrowRecord owns issue and return dates.
 *
 * Association:
 * Connects a Member with a Book.
 */

public class BorrowRecord {

    private int borrowId;
    private Book book;
    private Member member;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public BorrowRecord() {

    }

    public BorrowRecord(int borrowId,
            Book book,
            Member member,
            LocalDate issueDate,
            LocalDate returnDate) {

        this.borrowId = borrowId;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Borrow ID : " + borrowId +
                "\nBook : " + book.getTitle() +
                "\nMember : " + member.getName() +
                "\nIssue Date : " + issueDate +
                "\nReturn Date : " + returnDate;
    }

}