package practical10.GoodDesign;

public class CertificateRequest implements RequestCommand {

    @Override
    public void execute() {

        System.out.println("Certificate Request Submitted");

    }

}
