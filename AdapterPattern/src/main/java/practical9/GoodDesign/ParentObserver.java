package practical9.GoodDesign;

public class ParentObserver implements Observer {

    @Override
    public void update() {

        System.out.println("Parent Notified");

    }

}