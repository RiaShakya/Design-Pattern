package service;

import decorator.BasicReceipt;
import decorator.DateDecorator;
import decorator.QRCodeDecorator;
import decorator.Receipt;
import facade.LibraryFacade;

public class BorrowBook {

    public void process(String memberCode,
                        String book,
                        String role) {

        System.out.println("======================================");
        System.out.println("FACADE PATTERN");
        System.out.println("======================================");

        // Only members can borrow books
        if (!role.equalsIgnoreCase("MEMBER")) {

            System.out.println("Only Members can borrow books.");
            return;

        }

        LibraryFacade facade = new LibraryFacade();

        boolean success = facade.borrowBook(memberCode, book);

        // Proxy Pattern access control now happens once, right after login
        // (see Main.grantAccess), not repeated on every borrow action.

        // If the borrow failed (invalid title, book unavailable, etc.),
        // there is nothing to issue a receipt for.
        if (!success) {

            return;

        }

        System.out.println();

        System.out.println("======================================");
        System.out.println("DECORATOR PATTERN - BORROW RECEIPT");
        System.out.println("======================================");

        // Receipt is built up with the ACTUAL borrow details, not
        // placeholder text, so it reads as a real report.
        Receipt receipt = new BasicReceipt(memberCode, book);

        receipt = new DateDecorator(receipt);

        receipt = new QRCodeDecorator(receipt);

        System.out.println(receipt.print());

    }

}