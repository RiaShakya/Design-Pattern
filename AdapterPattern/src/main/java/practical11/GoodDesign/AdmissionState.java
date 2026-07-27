package practical11.GoodDesign;

public interface AdmissionState {

    void next(AdmissionApplication application);

    void showStatus();

}