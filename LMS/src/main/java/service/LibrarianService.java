package service;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LibrarianService {

    private final Scanner sc = new Scanner(System.in);

    // =========================================
    // LIBRARIAN MENU
    // =========================================

    public void showMenu() {

        while (true) {

            System.out.println("\n======================================");
            System.out.println("         LIBRARIAN MENU");
            System.out.println("======================================");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. View Borrow Records");
            System.out.println("6. View Payments");
            System.out.println("7. View Notifications");
            System.out.println("8. Logout");

            int choice = InputHelper.readInt(sc, "\nEnter Choice : ");

            switch (choice) {

                case 1:
                    viewBooks();
                    break;

                case 2:
                    addBook();
                    break;

                case 3:
                    updateBook();
                    break;

                case 4:
                    deleteBook();
                    break;

                case 5:
                    viewBorrowRecords();
                    break;

                case 6:
                    viewPayments();
                    break;

                case 7:
                    viewNotifications();
                    break;

                case 8:
                    System.out.println("Librarian Logged Out.");
                    return;

                default:
                    System.out.println("Invalid Choice.");

            }

        }

    }

    // =========================================
    // VIEW BOOKS
    // =========================================

    private void viewBooks() {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql = "SELECT * FROM books ORDER BY book_id";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            System.out.println("\n============== BOOK LIST ==============");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("------------------------------------");
                System.out.println("Book ID : " +
                        rs.getInt("book_id"));
                System.out.println("Title   : " +
                        rs.getString("title"));
                System.out.println("Author  : " +
                        rs.getString("author"));
                System.out.println("Status  : " +
                        rs.getString("status"));

            }

            if (!found) {

                System.out.println("No books found.");

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =========================================
    // VIEW BORROW RECORDS
    // =========================================

    private void viewBorrowRecords() {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "SELECT br.borrow_id, " +
                            "m.full_name, " +
                            "b.book_id, " +
                            "b.title, " +
                            "br.borrow_date, " +
                            "br.due_date, " +
                            "br.return_date " +
                            "FROM borrow_records br " +
                            "JOIN members m ON br.member_id = m.member_id " +
                            "JOIN books b ON br.book_id = b.book_id " +
                            "ORDER BY br.borrow_id";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            System.out.println("\n============= BORROW RECORDS =============");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------------");
                System.out.println("Borrow ID   : "
                        + rs.getInt("borrow_id"));
                System.out.println("Member      : "
                        + rs.getString("full_name"));
                System.out.println("Book ID     : "
                        + rs.getInt("book_id"));
                System.out.println("Book        : "
                        + rs.getString("title"));
                System.out.println("Borrow Date : "
                        + rs.getDate("borrow_date"));
                System.out.println("Due Date    : "
                        + rs.getDate("due_date"));

                java.sql.Date returnSqlDate = rs.getDate("return_date");

                String returnDate =
                        returnSqlDate != null
                                ? returnSqlDate.toString()
                                : "Not Returned Yet";

                System.out.println("Return Date : " + returnDate);

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

                System.out.println("No borrow records found.");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =========================================
    // ADD BOOK
    // =========================================

    private void addBook() {

        try {

            System.out.print("\nBook Title : ");
            String title = sc.nextLine();

            System.out.print("Author : ");
            String author = sc.nextLine();

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "INSERT INTO books(title, author, status) VALUES (?, ?, ?)";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, title);
            statement.setString(2, author);
            statement.setString(3, "AVAILABLE");

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("\nBook added successfully.");

            } else {

                System.out.println("\nFailed to add book.");

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =========================================
    // UPDATE BOOK
    // =========================================

    private void updateBook() {

        try {

            int bookId = InputHelper.readInt(sc, "\nBook ID : ");

            System.out.print("New Title : ");
            String title = sc.nextLine();

            System.out.print("New Author : ");
            String author = sc.nextLine();

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "UPDATE books SET title=?, author=? WHERE book_id=?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, bookId);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Book updated successfully.");

            } else {

                System.out.println("Book not found.");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =========================================
    // DELETE BOOK
    // =========================================

    private void deleteBook() {

        try {

            int bookId = InputHelper.readInt(sc, "\nBook ID : ");

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "DELETE FROM books WHERE book_id=?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, bookId);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Book deleted successfully.");

            } else {

                System.out.println("Book not found.");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =========================================
    // VIEW PAYMENTS
    // =========================================

    private void viewPayments() {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "SELECT p.payment_id, " +
                            "m.full_name, " +
                            "p.amount, " +
                            "p.payment_method, " +
                            "p.payment_date " +
                            "FROM payments p " +
                            "JOIN members m ON p.member_id = m.member_id " +
                            "ORDER BY p.payment_id";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            System.out.println("\n============== PAYMENTS ==============");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------------");
                System.out.println("Payment ID : "
                        + rs.getInt("payment_id"));
                System.out.println("Member     : "
                        + rs.getString("full_name"));
                System.out.println("Amount     : NPR "
                        + rs.getDouble("amount"));
                System.out.println("Method     : "
                        + rs.getString("payment_method"));
                System.out.println("Date       : "
                        + rs.getDate("payment_date"));

            }

            if (!found) {

                System.out.println("No payments found.");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =========================================
    // VIEW NOTIFICATIONS
    // =========================================

    private void viewNotifications() {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "SELECT n.notification_id, " +
                            "m.full_name, " +
                            "n.notification_type, " +
                            "n.message, " +
                            "n.sent_date " +
                            "FROM notifications n " +
                            "JOIN members m ON n.member_id = m.member_id " +
                            "ORDER BY n.notification_id";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            System.out.println("\n============== NOTIFICATIONS ==============");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------------");
                System.out.println("ID      : "
                        + rs.getInt("notification_id"));
                System.out.println("Member  : "
                        + rs.getString("full_name"));
                System.out.println("Type    : "
                        + rs.getString("notification_type"));
                System.out.println("Message : "
                        + rs.getString("message"));
                System.out.println("Sent At : "
                        + rs.getTimestamp("sent_date"));

            }

            if (!found) {

                System.out.println("No notifications found.");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}