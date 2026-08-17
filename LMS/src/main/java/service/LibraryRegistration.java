package service;

import builder.Member;
import database.DatabaseConnection;
import factory.Notification;
import factory.NotificationFactory;
import singleton.LibraryConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LibraryRegistration {

    public void register(Member member, String notificationType) {

        LibraryConfig config = LibraryConfig.getInstance();

        System.out.println("=========================================");
        System.out.println("SINGLETON PATTERN - LIBRARY CONFIGURATION");
        System.out.println("=========================================");

        System.out.println("Library Name   : " + config.getLibraryName());
        System.out.println("Version        : " + config.getSystemVersion());
        System.out.println("Librarian      : " + config.getLibrarian());

        System.out.println();

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String checkQuery =
                    "SELECT * FROM members WHERE member_id = ?";

            PreparedStatement checkStatement =
                    connection.prepareStatement(checkQuery);

            checkStatement.setString(1, member.getMemberId());

            ResultSet result = checkStatement.executeQuery();

            if (result.next()) {

                System.out.println("Member ID already exists.");

            } else {

                String insertQuery =
                        "INSERT INTO members(member_id,full_name,email,phone,address) VALUES(?,?,?,?,?)";

                PreparedStatement statement =
                        connection.prepareStatement(insertQuery);

                statement.setString(1, member.getMemberId());
                statement.setString(2, member.getName());
                statement.setString(3, member.getEmail());
                statement.setString(4, member.getPhone());
                statement.setString(5, member.getAddress());

                statement.executeUpdate();

                System.out.println("=========================================");
                System.out.println("BUILDER PATTERN - MEMBER REGISTERED");
                System.out.println("=========================================");

                System.out.println("Member ID      : " + member.getMemberId());
                System.out.println("Name           : " + member.getName());
                System.out.println("Email          : " + member.getEmail());
                System.out.println("Phone          : " + member.getPhone());
                System.out.println("Address        : " + member.getAddress());

                System.out.println();

                System.out.println("=========================================");
                System.out.println("FACTORY METHOD PATTERN - NOTIFICATION");
                System.out.println("=========================================");

                Notification notification =
                        NotificationFactory.createNotification(notificationType);

                String message =
                        "Welcome " + member.getName()
                                + " to "
                                + config.getLibraryName();

                notification.sendNotification(message);

                // Persist the notification in the database
                NotificationLogger.log(
                        member.getMemberId(), message, notificationType.toUpperCase());

                System.out.println("Member saved successfully.");

            }

        } catch (Exception e) {

            System.out.println("Registration Failed.");
            e.printStackTrace();

        }

    }

}