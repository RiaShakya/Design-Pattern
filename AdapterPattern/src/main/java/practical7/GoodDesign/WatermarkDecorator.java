package practical7.GoodDesign;

public class WatermarkDecorator extends ReportDecorator {

    public WatermarkDecorator(Report report) {
        super(report);
    }

    @Override
    public void generate() {

        report.generate();
        System.out.println("Watermark Added");

    }

}