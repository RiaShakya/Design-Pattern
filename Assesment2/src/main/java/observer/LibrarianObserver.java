package observer;

public class LibrarianObserver implements Observer {

    @Override
    public void update(String message) {

        System.out.println("Librarian Notification : " + message);

    }

}