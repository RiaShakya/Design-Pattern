package service;

import command.FineReceiptCommand;
import command.LibraryServiceInvoker;
import database.DatabaseConnection;
import observer.LibrarianObserver;
import observer.LibraryNotification;
import observer.MemberObserver;
import strategy.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class LibraryWorkflow {

    public void process(String role,
                        String member,
                        double fine,
                        String paymentMethod) {

        System.out.println("=========================================");
        System.out.println("STRATEGY PATTERN - PAYMENT");
        System.out.println("=========================================");

        // Only Members pay fines
        if (!role.equalsIgnoreCase("MEMBER")) {

            System.out.println("No payment required for " + role + ".");

        } else {

            PaymentContext context = new PaymentContext();

            switch (paymentMethod.toLowerCase()) {

                case "cash":
                    context.setStrategy(new CashPayment());
                    break;

                case "card":
                    context.setStrategy(new CardPayment());
                    break;

                default:
                    context.setStrategy(new EsewaPayment());

            }

            context.processPayment(fine);

            try {

                Connection connection =
                        DatabaseConnection.getInstance().getConnection();

                PreparedStatement memberStatement =
                        connection.prepareStatement(
                                "SELECT member_id FROM members WHERE member_id=?");

                memberStatement.setString(1, member);

                ResultSet rs = memberStatement.executeQuery();

                if (rs.next()) {

                    String memberId = rs.getString("member_id");

                    PreparedStatement payment =
                            connection.prepareStatement(
                                    "INSERT INTO payments(member_id,amount,payment_method,payment_date) VALUES(?,?,?,?)");

                    payment.setString(1, memberId);
                    payment.setDouble(2, fine);
                    payment.setString(3, paymentMethod);
                    payment.setDate(4, java.sql.Date.valueOf(LocalDate.now()));

                    payment.executeUpdate();

                }

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        System.out.println();

        System.out.println("=========================================");
        System.out.println("OBSERVER PATTERN");
        System.out.println("=========================================");

        LibraryNotification notification = new LibraryNotification();

        notification.addObserver(new MemberObserver());
        notification.addObserver(new LibrarianObserver());

        // The notification must reflect what actually happened here:
        // a fine payment, NOT a book being issued.
        String message =
                "Fine payment of NPR " + fine + " received successfully.";

        notification.notifyObservers(message);

        // Persist the notification in the database (skipped for non-members,
        // since no member is tied to the payment in that case)
        if (role.equalsIgnoreCase("MEMBER")) {

            NotificationLogger.log(member, message, "OBSERVER");

        }

        System.out.println();

        System.out.println("=========================================");
        System.out.println("COMMAND PATTERN");
        System.out.println("=========================================");

        // Only the command relevant to this workflow (paying a fine) is
        // executed. Borrow History / Membership Card commands do not apply
        // here and were being printed unnecessarily.
        LibraryServiceInvoker invoker = new LibraryServiceInvoker();

        invoker.execute(new FineReceiptCommand());

    }

}