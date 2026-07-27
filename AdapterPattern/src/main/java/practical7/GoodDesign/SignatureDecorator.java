package practical7.GoodDesign;

public class SignatureDecorator extends ReportDecorator {

    public SignatureDecorator(Report report) {
        super(report);
    }

    @Override
    public void generate() {

        report.generate();
        System.out.println("Signature Added");

    }

}