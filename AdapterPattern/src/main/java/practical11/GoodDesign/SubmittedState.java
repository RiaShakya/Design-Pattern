package practical11.GoodDesign;

import practical11.GoodDesign.AdmissionApplication;

public class SubmittedState implements AdmissionState {

    @Override
    public void next(AdmissionApplication application) {

        application.setState(new VerifiedState());

    }

    @Override
    public void showStatus() {

        System.out.println("Current State : Submitted");

    }

}
