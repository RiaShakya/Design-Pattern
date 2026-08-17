package facade;

import adapter.EmailAdapter;
import adapter.NotificationService;
import service.NotificationLogger;
import state.BookContext;
import state.IssuedState;

public class LibraryFacade {

    private BookValidator validator = new BookValidator();
    private BookRepository repository = new BookRepository();
    private BorrowService borrowService = new BorrowService();

    public boolean borrowBook(String memberCode, String bookTitle) {

        // ==========================
        // Validate Input
        // ==========================

        if (!validator.validate(bookTitle)) {

            System.out.println("Invalid Book Title.");
            return false;

        }

        // ==========================
        // Issue Book
        // ==========================

        boolean issued = repository.issueBook(bookTitle);

        if (!issued) {

            System.out.println("Borrow Process Failed.");
            return false;

        }

        // ==========================
        // Save Borrow Record
        // ==========================

        boolean saved =
                borrowService.borrow(memberCode, bookTitle);

        if (!saved) {

            System.out.println("Borrow Record Failed.");

            return false;

        }

        // ==========================
        // Send Notification
        // ==========================

        NotificationService notification =
                new EmailAdapter();

        // Notification reflects the actual, correct status of the book: ISSUED.
        String message =
                "Book \"" + bookTitle +
                        "\" has been ISSUED to " + memberCode +
                        ". Please return it within 3 days.";

        notification.sendNotification(message);

        // Persist the notification in the database
        NotificationLogger.log(memberCode, message, "EMAIL");

        System.out.println();

        System.out.println("======================================");
        System.out.println("STATE PATTERN");
        System.out.println("======================================");

        BookContext book = new BookContext();

        book.setState(new IssuedState());
        book.showStatus();

        System.out.println();
        System.out.println("Borrow Process Completed Successfully.");

        return true;

    }

}