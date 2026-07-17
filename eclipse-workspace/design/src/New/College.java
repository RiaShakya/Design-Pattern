package New;

interface Book {
    void getBookDetails();
}

class TextBook implements Book {
    public void getBookDetails() {
        System.out.println("Textbook issued");
    }
}

class Novel implements Book {
    public void getBookDetails() {
        System.out.println("Novel issued");
    }
}

class Library {
    Book book;

    Library(Book book) {
        this.book = book;
    }

    void issueBook() {
        book.getBookDetails();
    }
}

public class College {
    public static void main(String[] args) {

        Library l1 = new Library(new TextBook());
        l1.issueBook();

        Library l2 = new Library(new Novel());
        l2.issueBook();
    }
}
