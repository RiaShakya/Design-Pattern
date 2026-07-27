package practical9.GoodDesign;

public class StudentObserver implements Observer {

    @Override
    public void update() {

        System.out.println("Student Notified");

    }

}