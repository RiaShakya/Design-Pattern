package state;

public class IssuedState implements BookState {

    @Override
    public void handle() {

        System.out.println("Book Status : Issued");

    }

}