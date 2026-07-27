package state;

public class BookContext {

    private BookState state;

    public void setState(BookState state){

        this.state = state;

    }

    public void showStatus(){

        state.handle();

    }

}