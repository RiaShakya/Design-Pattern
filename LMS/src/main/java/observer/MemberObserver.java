package observer;

public class MemberObserver implements Observer {

    @Override
    public void update(String message) {

        System.out.println("Member Notification : " + message);

    }

}