package practical10.GoodDesign;

public class TranscriptRequest implements RequestCommand {

    @Override
    public void execute() {

        System.out.println("Transcript Request Submitted");

    }

}