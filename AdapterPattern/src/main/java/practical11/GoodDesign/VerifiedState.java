package practical11.GoodDesign;

public class VerifiedState implements AdmissionState {

    @Override
    public void next(AdmissionApplication application) {

        application.setState(new ApprovedState());

    }

    @Override
    public void showStatus() {

        System.out.println("Current State : Verified");

    }

}
