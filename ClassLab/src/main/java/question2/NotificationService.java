package question2;

public class NotificationService {

    private Notification notification;

    public NotificationService(Notification notification){
        this.notification = notification;
    }

    public void sendNotification(){
        notification.send();
    }

    public static void main(String[] args){

        NotificationService sms = new NotificationService(new SMSNotification());

        NotificationService email = new NotificationService(new EmailNotification());

        sms.sendNotification();
        email.sendNotification();
    }
}
