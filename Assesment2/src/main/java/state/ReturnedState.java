package state;

public class ReturnedState implements BookState {

    @Override
    public void handle() {

        System.out.println("Book Status : Returned");

    }

}