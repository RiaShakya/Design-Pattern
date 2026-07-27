package practical11.GoodDesign;

public class AdmissionApplication {

    private AdmissionState state;

    public AdmissionApplication() {

        state = new SubmittedState();

    }

    public void setState(AdmissionState state) {

        this.state = state;

    }

    public void nextState() {

        state.next(this);

    }

    public void showStatus() {

        state.showStatus();

    }

}
