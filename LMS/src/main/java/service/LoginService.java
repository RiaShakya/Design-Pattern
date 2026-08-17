package service;

import java.util.Scanner;
import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    private final Scanner sc = new Scanner(System.in);
    private static String loggedInMemberCode;
    // ===========================
    // ADMIN LOGIN
    // ===========================

    public boolean adminLogin() {

        System.out.println("\n========== ADMIN LOGIN ==========");

        System.out.print("Username : ");
        String username = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        if (username.equals("admin") && password.equals("admin123")) {

            System.out.println("Admin Login Successful.");
            return true;

        }

        System.out.println("Invalid Admin Credentials.");
        return false;

    }

    // ===========================
    // LIBRARIAN LOGIN
    // ===========================

    public boolean librarianLogin() {

        System.out.println("\n======= LIBRARIAN LOGIN =======");

        System.out.print("Username : ");
        String username = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        if (username.equals("librarian") && password.equals("lib123")) {

            System.out.println("Librarian Login Successful.");
            return true;

        }

        System.out.println("Invalid Librarian Credentials.");
        return false;

    }

    // ===========================
    // MEMBER LOGIN
    // ===========================

    // ===========================
// MEMBER LOGIN
// ===========================

    public boolean memberLogin() {

        System.out.println("\n========== MEMBER LOGIN ==========");

        System.out.print("Member Code : ");
        String memberCode = sc.nextLine();

        System.out.print("Email : ");
        String email = sc.nextLine();

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "SELECT * FROM members WHERE member_id=? AND email=?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, memberCode);
            statement.setString(2, email);

            ResultSet rs =
                    statement.executeQuery();

            if (rs.next()) {

                loggedInMemberCode = memberCode;

                System.out.println("Member Login Successful.");

                return true;

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        System.out.println("Invalid Member Credentials.");

        return false;

    }
    public static String getLoggedInMemberCode() {

        return loggedInMemberCode;

    }
}