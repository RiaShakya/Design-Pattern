package service;

import decorator.BasicReceipt;
import decorator.DateDecorator;
import decorator.QRCodeDecorator;
import decorator.Receipt;
import facade.LibraryFacade;
import proxy.LibraryProxy;

public class BorrowBook {

    public void process(String member,
                        String book,
                        String role){

        System.out.println("======================================");
        System.out.println("FACADE PATTERN");
        System.out.println("======================================");

        LibraryFacade facade=new LibraryFacade();

        facade.borrowBook(member,book);

        System.out.println();

        System.out.println("======================================");
        System.out.println("PROXY PATTERN");
        System.out.println("======================================");

        LibraryProxy proxy=new LibraryProxy(role);

        proxy.accessRecord();

        System.out.println();

        System.out.println("======================================");
        System.out.println("DECORATOR PATTERN");
        System.out.println("======================================");

        Receipt receipt=new BasicReceipt();

        receipt=new DateDecorator(receipt);

        receipt=new QRCodeDecorator(receipt);

        System.out.println(receipt.print());

    }

}