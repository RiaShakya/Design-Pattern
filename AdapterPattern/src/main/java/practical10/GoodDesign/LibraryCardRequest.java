package practical10.GoodDesign;

public class LibraryCardRequest implements RequestCommand {

    @Override
    public void execute() {

        System.out.println("Library Card Request Submitted");

    }

}
