package LibraryManagement.repository;

import java.util.ArrayList;
import java.util.List;

import LibraryManagement.model.Book;

/*
 * SRP:
 * This class only manages Book objects.
 *
 * OCP:
 * Additional storage mechanisms (DatabaseBookRepository, FileBookRepository)
 * can be added without modifying this class.
 */

public class BookRepository {

    // Aggregation: Library maintains a collection of books.
    private List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
    }

    // ---------------- Add Book ----------------

    public void addBook(Book book) {

        books.add(book);

        System.out.println("Book added successfully.");
    }

    // ---------------- View All ----------------

    public List<Book> getAllBooks() {
        return books;
    }

    // ---------------- Search ----------------

    public Book searchBookById(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }

        }

        return null;
    }

    public List<Book> searchBookByTitle(String title) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                result.add(book);

            }

        }

        return result;
    }

    // ---------------- Update ----------------

    public boolean updateBook(int id,
                              String title,
                              String author,
                              String category,
                              boolean available) {

        Book book = searchBookById(id);

        if (book == null) {

            return false;

        }

        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvailable(available);

        return true;
    }

    // ---------------- Delete ----------------

    public boolean deleteBook(int id) {

        Book book = searchBookById(id);

        if (book != null) {

            books.remove(book);

            return true;

        }

        return false;
    }

    // ---------------- Availability ----------------

    public boolean isBookAvailable(int id) {

        Book book = searchBookById(id);

        return book != null && book.isAvailable();

    }

    public boolean issueBook(int id) {

        Book book = searchBookById(id);

        if (book != null && book.isAvailable()) {

            book.setAvailable(false);

            return true;

        }

        return false;
    }

    public boolean returnBook(int id) {

        Book book = searchBookById(id);

        if (book != null) {

            book.setAvailable(true);

            return true;

        }

        return false;
    }

    // ---------------- Display ----------------

    public void displayBooks() {

        if (books.isEmpty()) {

            System.out.println("No books available.");

            return;

        }

        for (Book book : books) {

            System.out.println("------------------------");
            System.out.println(book);

        }

    }

}