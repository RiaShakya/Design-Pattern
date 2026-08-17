package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    // PostgreSQL Database Configuration
    private static final String URL = "jdbc:postgresql://localhost:5432/LibraryDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234"; // Change if your password is different

    private DatabaseConnection() {
        connect();
    }

    private void connect() {

        try {

            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println();
            System.out.println("======================================");
            System.out.println(" Connected to PostgreSQL Successfully");
            System.out.println(" Database : LibraryDB");
            System.out.println("======================================");

        } catch (ClassNotFoundException e) {

            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Failed to connect to PostgreSQL.");
            e.printStackTrace();

        }

    }

    public static synchronized DatabaseConnection getInstance() {

        if (instance == null) {

            instance = new DatabaseConnection();

        }

        return instance;

    }

    public Connection getConnection() {

        try {

            if (connection == null || connection.isClosed()) {

                connect();

            }

        } catch (SQLException e) {

            connect();

        }

        return connection;

    }

    public void closeConnection() {

        try {

            if (connection != null && !connection.isClosed()) {

                connection.close();

                System.out.println("Database connection closed.");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}