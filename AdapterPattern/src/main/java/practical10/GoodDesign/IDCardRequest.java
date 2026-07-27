package practical10.GoodDesign;

public class IDCardRequest implements RequestCommand {

    @Override
    public void execute() {

        System.out.println("ID Card Request Submitted");

    }

}
