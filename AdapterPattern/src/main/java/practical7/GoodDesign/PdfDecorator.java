package practical7.GoodDesign;

public class PdfDecorator extends ReportDecorator {

    public PdfDecorator(Report report) {
        super(report);
    }

    @Override
    public void generate() {

        report.generate();
        System.out.println("PDF Feature Added");

    }

}
