package practical11.GoodDesign;

public class ApprovedState implements AdmissionState {

    @Override
    public void next(AdmissionApplication application) {

        application.setState(new EnrolledState());

    }

    @Override
    public void showStatus() {

        System.out.println("Current State : Approved");

    }

}
