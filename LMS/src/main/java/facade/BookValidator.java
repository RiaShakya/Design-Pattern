package facade;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookValidator {

    public boolean validate(String book) {

        if (book == null || book.trim().isEmpty()) {

            System.out.println("Book title cannot be empty.");
            return false;

        }

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql = "SELECT * FROM books WHERE title = ?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, book);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return true;

            }

            System.out.println("Book does not exist in the library.");
            return false;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }

}