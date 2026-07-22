package practical7.GoodDesign;

public abstract class ReportDecorator implements Report {

    protected Report report;

    public ReportDecorator(Report report) {

        this.report = report;

    }

}