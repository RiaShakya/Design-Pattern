package service;

import command.BorrowHistoryCommand;
import command.FineReceiptCommand;
import command.LibraryServiceInvoker;
import command.MembershipCardCommand;
import observer.LibrarianObserver;
import observer.LibraryNotification;
import observer.MemberObserver;
import state.AvailableState;
import state.BookContext;
import state.IssuedState;
import state.ReturnedState;
import strategy.*;

public class LibraryWorkflow {

    public void process(double fine, String paymentMethod){

        System.out.println("=========================================");
        System.out.println("STRATEGY PATTERN - PAYMENT");
        System.out.println("=========================================");

        PaymentContext context = new PaymentContext();

        switch(paymentMethod.toLowerCase()){

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

        System.out.println();

        System.out.println("=========================================");
        System.out.println("OBSERVER PATTERN");
        System.out.println("=========================================");

        LibraryNotification notification = new LibraryNotification();

        notification.addObserver(new MemberObserver());
        notification.addObserver(new LibrarianObserver());

        notification.notifyObservers("Book issued successfully.");

        System.out.println();

        System.out.println("=========================================");
        System.out.println("COMMAND PATTERN");
        System.out.println("=========================================");

        LibraryServiceInvoker invoker = new LibraryServiceInvoker();

        invoker.execute(new BorrowHistoryCommand());
        invoker.execute(new FineReceiptCommand());
        invoker.execute(new MembershipCardCommand());

        System.out.println();

        System.out.println("=========================================");
        System.out.println("STATE PATTERN");
        System.out.println("=========================================");

        BookContext book = new BookContext();

        book.setState(new AvailableState());
        book.showStatus();

        book.setState(new IssuedState());
        book.showStatus();

        book.setState(new ReturnedState());
        book.showStatus();

    }

}