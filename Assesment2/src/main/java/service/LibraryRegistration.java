package service;

import builder.Member;
import factory.Notification;
import factory.NotificationFactory;
import singleton.LibraryConfig;

public class LibraryRegistration {

    public void register(Member member, String notificationType){

        LibraryConfig config = LibraryConfig.getInstance();

        System.out.println("=========================================");
        System.out.println("SINGLETON PATTERN - LIBRARY CONFIGURATION");
        System.out.println("=========================================");

        System.out.println("Library Name   : " + config.getLibraryName());
        System.out.println("Version        : " + config.getSystemVersion());
        System.out.println("Librarian      : " + config.getLibrarian());

        System.out.println();

        System.out.println("=========================================");
        System.out.println("BUILDER PATTERN - MEMBER REGISTRATION");
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

        notification.sendNotification(
                "Welcome " + member.getName() +
                        " to " + config.getLibraryName());

    }

}