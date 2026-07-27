package facade;

public class BookValidator {

    public boolean validate(String book){

        return !book.isEmpty();

    }

}