package facade;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BorrowService {

    public boolean borrow(String memberCode, String bookTitle) {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            // ============================
            // Get Member ID
            // ============================

            String memberSql = "SELECT member_id FROM members WHERE member_id=?";

            PreparedStatement memberStatement =
                    connection.prepareStatement(memberSql);

            memberStatement.setString(1, memberCode);

            ResultSet memberResult =
                    memberStatement.executeQuery();

            if (!memberResult.next()) {

                System.out.println("Member not found.");
                return false;

            }

            String memberId =
                    memberResult.getString("member_id");

            // ============================
            // Get Book ID
            // ============================

            String bookSql =
                    "SELECT book_id FROM books WHERE title = ?";

            PreparedStatement bookStatement =
                    connection.prepareStatement(bookSql);

            bookStatement.setString(1, bookTitle);

            ResultSet bookResult =
                    bookStatement.executeQuery();

            if (!bookResult.next()) {

                System.out.println("Book not found.");
                return false;

            }

            int bookId =
                    bookResult.getInt("book_id");

            // ============================
            // Save Borrow Record
            // ============================

            // Due date is fixed at 3 days from the borrow date
            String borrowSql =
                    "INSERT INTO borrow_records(member_id, book_id, borrow_date, due_date) " +
                            "VALUES (?, ?, CURRENT_DATE, CURRENT_DATE + INTERVAL '3 days')";

            PreparedStatement borrowStatement =
                    connection.prepareStatement(borrowSql);

            borrowStatement.setString(1, memberId);
            borrowStatement.setInt(2, bookId);

            borrowStatement.executeUpdate();

            System.out.println("Borrow record saved successfully.");

            return true;

        }

        catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }

}