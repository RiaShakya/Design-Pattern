package practical11.GoodDesign;

public class RejectedState implements AdmissionState {

    @Override
    public void next(AdmissionApplication application) {

        System.out.println("Application Rejected");

    }

    @Override
    public void showStatus() {

        System.out.println("Current State : Rejected");

    }

}
