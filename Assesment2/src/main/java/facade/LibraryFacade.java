package facade;

import adapter.EmailAdapter;
import adapter.NotificationService;

public class LibraryFacade {

    private BookValidator validator = new BookValidator();
    private BookRepository repository = new BookRepository();
    private BorrowService borrowService = new BorrowService();

    public void borrowBook(String member,String book){

        if(!validator.validate(book)){

            System.out.println("Invalid Book");
            return;

        }

        repository.issueBook(book);

        borrowService.borrow(member);

        NotificationService notification = new EmailAdapter();

        notification.sendNotification(
                "Book borrowed successfully.");

    }

}