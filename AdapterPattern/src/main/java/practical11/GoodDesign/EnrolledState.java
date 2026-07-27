package practical11.GoodDesign;

public class EnrolledState implements AdmissionState {

    @Override
    public void next(AdmissionApplication application) {

        System.out.println("Admission Process Completed");

    }

    @Override
    public void showStatus() {

        System.out.println("Current State : Enrolled");

    }

}
