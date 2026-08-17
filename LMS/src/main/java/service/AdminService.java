package service;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AdminService {

    private final Scanner sc = new Scanner(System.in);
    public void showMenu() {

        while (true) {

            System.out.println("\n======================================");
            System.out.println("            ADMIN MENU");
            System.out.println("======================================");
            System.out.println("1. View Members");
            System.out.println("2. Delete Member");
            System.out.println("3. View Books");
            System.out.println("4. Delete Book");
            System.out.println("5. View Borrow Records");
            System.out.println("6. View Payments");
            System.out.println("7. View Notifications");
            System.out.println("8. Logout");

            int choice = InputHelper.readInt(sc, "\nEnter Choice : ");

            switch (choice) {

                case 1:
                    viewMembers();
                    break;

                case 2:
                    deleteMember();
                    break;

                case 3:
                    viewBooks();
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
                    System.out.println("Admin Logged Out.");
                    return;

                default:
                    System.out.println("Invalid Choice.");

            }

        }

    }

    // =====================================
    // VIEW MEMBERS
    // =====================================

    private void viewMembers() {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql = "SELECT * FROM members";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            System.out.println("\n================ MEMBERS ================");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------------");
                System.out.println("Member ID : "
                        + rs.getString("member_id"));
                System.out.println("Name      : "
                        + rs.getString("full_name"));
                System.out.println("Email     : "
                        + rs.getString("email"));
                System.out.println("Phone     : "
                        + rs.getString("phone"));
                System.out.println("Address   : "
                        + rs.getString("address"));

            }

            if (!found) {

                System.out.println("No members found.");

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =====================================
    // VIEW BOOKS
    // =====================================

    private void viewBooks() {

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
                System.out.println("Book ID : "
                        + rs.getInt("book_id"));
                System.out.println("Title   : "
                        + rs.getString("title"));
                System.out.println("Author  : "
                        + rs.getString("author"));
                System.out.println("Status  : "
                        + rs.getString("status"));

            }

            if (!found) {

                System.out.println("No books found.");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =====================================
    // DELETE BOOK
    // =====================================

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

    // =====================================
    // VIEW BORROW RECORDS
    // =====================================

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

    // =====================================
    // DELETE MEMBER
    // =====================================

    private void deleteMember() {

        try {

            System.out.print("\nEnter Member ID to Delete : ");
            String memberId = sc.nextLine();

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql = "DELETE FROM members WHERE member_id = ?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, memberId);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Member deleted successfully.");

            } else {

                System.out.println("Member not found.");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // =====================================
    // VIEW PAYMENTS
    // =====================================

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

    // =====================================
    // VIEW NOTIFICATIONS
    // =====================================

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