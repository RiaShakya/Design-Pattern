package factory;

public class SMSNotification implements Notification{

    @Override
    public void sendNotification(String message) {

        System.out.println("Sending SMS Notification...");
        System.out.println("Message : " + message);

    }
}