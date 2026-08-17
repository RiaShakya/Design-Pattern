package service;

import database.DatabaseConnection;
import state.AvailableState;
import state.BookContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MemberService {

    public static final double FINE_PER_DAY = 50.0;

    // =====================================
    // VIEW ALL BOOKS
    // =====================================

    public void viewAllBooks() {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql = "SELECT * FROM books ORDER BY book_id";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            System.out.println("\n================ BOOKS ================");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------------");
                System.out.println("Book ID : " + rs.getInt("book_id"));
                System.out.println("Title   : " + rs.getString("title"));
                System.out.println("Author  : " + rs.getString("author"));
                System.out.println("Status  : " + rs.getString("status"));

            }

            if (!found) {

                System.out.println("No books available in the library.");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =====================================
    // SEARCH BOOKS (by title or author)
    // =====================================

    public void searchBooks(String keyword) {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "SELECT * FROM books " +
                            "WHERE title ILIKE ? OR author ILIKE ? " +
                            "ORDER BY book_id";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            String pattern = "%" + keyword + "%";

            statement.setString(1, pattern);
            statement.setString(2, pattern);

            ResultSet rs = statement.executeQuery();

            System.out.println("\n============ SEARCH RESULTS ============");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------------");
                System.out.println("Book ID : " + rs.getInt("book_id"));
                System.out.println("Title   : " + rs.getString("title"));
                System.out.println("Author  : " + rs.getString("author"));
                System.out.println("Status  : " + rs.getString("status"));

            }

            if (!found) {

                System.out.println("No books matched \"" + keyword + "\".");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =====================================
    // MY BORROW HISTORY
    // =====================================

    public void viewBorrowHistory(String memberId) {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "SELECT br.borrow_id, " +
                            "b.book_id, " +
                            "b.title, " +
                            "br.borrow_date, " +
                            "br.due_date, " +
                            "br.return_date " +
                            "FROM borrow_records br " +
                            "JOIN books b ON br.book_id = b.book_id " +
                            "WHERE br.member_id = ? " +
                            "ORDER BY br.borrow_id";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, memberId);

            ResultSet rs = statement.executeQuery();

            System.out.println("\n============ MY BORROW HISTORY ============");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------------");
                System.out.println("Borrow ID   : " + rs.getInt("borrow_id"));
                System.out.println("Book ID     : " + rs.getInt("book_id"));
                System.out.println("Book        : " + rs.getString("title"));
                System.out.println("Borrow Date : " + rs.getDate("borrow_date"));
                System.out.println("Due Date    : " + rs.getDate("due_date")
                        + "  (3 days from borrow date)");

                java.sql.Date returnSqlDate = rs.getDate("return_date");

                String returnDate =
                        returnSqlDate != null
                                ? returnSqlDate.toString()
                                : "Not Returned Yet";

                System.out.println("Return Date : " + returnDate);

                // Show whether the book is overdue for borrows not yet returned
                if (returnSqlDate == null) {

                    java.sql.Date dueSqlDate = rs.getDate("due_date");

                    if (dueSqlDate != null
                            && dueSqlDate.toLocalDate().isBefore(java.time.LocalDate.now())) {

                        System.out.println("Status      : OVERDUE");

                    } else {

                        System.out.println("Status      : ISSUED");

                    }

                } else {

                    System.out.println("Status      : RETURNED");

                }

            }

            if (!found) {

                System.out.println("You have no borrow history yet.");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =====================================
    // RETURN BOOK
    // =====================================

    public void returnBook(String memberId, int bookId) {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            // Confirm this member actually has this book borrowed and unreturned
            String checkSql =
                    "SELECT * FROM borrow_records " +
                            "WHERE member_id = ? AND book_id = ? AND return_date IS NULL";

            PreparedStatement checkStatement =
                    connection.prepareStatement(checkSql);

            checkStatement.setString(1, memberId);
            checkStatement.setInt(2, bookId);

            ResultSet rs = checkStatement.executeQuery();

            if (!rs.next()) {

                System.out.println("You do not have this book currently borrowed.");
                return;

            }

            String borrowSql =
                    "UPDATE borrow_records " +
                            "SET return_date = CURRENT_DATE " +
                            "WHERE member_id = ? AND book_id = ? AND return_date IS NULL";

            PreparedStatement borrowStatement =
                    connection.prepareStatement(borrowSql);

            borrowStatement.setString(1, memberId);
            borrowStatement.setInt(2, bookId);

            borrowStatement.executeUpdate();

            String bookSql =
                    "UPDATE books SET status = 'AVAILABLE' WHERE book_id = ?";

            PreparedStatement bookStatement =
                    connection.prepareStatement(bookSql);

            bookStatement.setInt(1, bookId);

            bookStatement.executeUpdate();

            System.out.println("Book returned successfully.");

            System.out.println();
            System.out.println("======================================");
            System.out.println("STATE PATTERN");
            System.out.println("======================================");

            BookContext book = new BookContext();

            book.setState(new AvailableState());
            book.showStatus();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =====================================
    // VIEW PAYMENT HISTORY
    // =====================================

    public void viewPaymentHistory(String memberId) {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "SELECT payment_id, amount, payment_method, payment_date " +
                            "FROM payments " +
                            "WHERE member_id = ? " +
                            "ORDER BY payment_id";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, memberId);

            ResultSet rs = statement.executeQuery();

            System.out.println("\n============== MY PAYMENT HISTORY ==============");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------------");
                System.out.println("Payment ID : " + rs.getInt("payment_id"));
                System.out.println("Amount     : NPR " + rs.getDouble("amount"));
                System.out.println("Method     : " + rs.getString("payment_method"));
                System.out.println("Date       : " + rs.getDate("payment_date"));

            }

            if (!found) {

                System.out.println("You have no payment history yet.");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =====================================
    // VIEW MY NOTIFICATIONS
    // =====================================

    public void viewMyNotifications(String memberId) {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "SELECT notification_id, message, notification_type, sent_date " +
                            "FROM notifications " +
                            "WHERE member_id = ? " +
                            "ORDER BY notification_id";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, memberId);

            ResultSet rs = statement.executeQuery();

            System.out.println("\n============== MY NOTIFICATIONS ==============");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------------");
                System.out.println("ID      : " + rs.getInt("notification_id"));
                System.out.println("Type    : " + rs.getString("notification_type"));
                System.out.println("Message : " + rs.getString("message"));
                System.out.println("Sent At : " + rs.getTimestamp("sent_date"));

            }

            if (!found) {

                System.out.println("You have no notifications yet.");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =====================================
    // CALCULATE FINE (NPR 50 per day, per overdue book)
    // =====================================

    public double calculateFine(String memberId) {

        double fine = 0;

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "SELECT due_date " +
                            "FROM borrow_records " +
                            "WHERE member_id = ? " +
                            "AND return_date IS NULL " +
                            "AND due_date < CURRENT_DATE";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, memberId);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                LocalDate dueDate = rs.getDate("due_date").toLocalDate();

                long overdueDays =
                        ChronoUnit.DAYS.between(dueDate, LocalDate.now());

                if (overdueDays > 0) {

                    fine += overdueDays * FINE_PER_DAY;

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return fine;

    }

}