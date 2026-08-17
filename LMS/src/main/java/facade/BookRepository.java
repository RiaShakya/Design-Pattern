package facade;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookRepository {

    public boolean issueBook(String bookTitle) {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            // Check if the book exists and is available
            String checkSql =
                    "SELECT * FROM books WHERE title = ? AND status = 'AVAILABLE'";

            PreparedStatement checkStatement =
                    connection.prepareStatement(checkSql);

            checkStatement.setString(1, bookTitle);

            ResultSet rs = checkStatement.executeQuery();

            if (!rs.next()) {

                System.out.println("Book does not exist or is already issued.");
                return false;

            }

            // Update status to ISSUED
            String updateSql =
                    "UPDATE books SET status='ISSUED' WHERE title=?";

            PreparedStatement updateStatement =
                    connection.prepareStatement(updateSql);

            updateStatement.setString(1, bookTitle);

            updateStatement.executeUpdate();

            System.out.println(bookTitle + " issued successfully.");

            return true;

        }

        catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }

}