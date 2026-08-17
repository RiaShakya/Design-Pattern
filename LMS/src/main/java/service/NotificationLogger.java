package service;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class NotificationLogger {

    public static void log(String memberId, String message, String notificationType) {

        try {

            Connection connection =
                    DatabaseConnection.getInstance().getConnection();

            String sql =
                    "INSERT INTO notifications(member_id, message, notification_type) " +
                            "VALUES (?, ?, ?)";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, memberId);
            statement.setString(2, message);
            statement.setString(3, notificationType);

            statement.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}