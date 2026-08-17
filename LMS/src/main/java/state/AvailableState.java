package state;

public class AvailableState implements BookState {

    @Override
    public void handle() {

        System.out.println("Book Status : Available");

    }

}