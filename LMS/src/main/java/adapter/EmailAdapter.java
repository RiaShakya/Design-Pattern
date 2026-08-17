package adapter;

public class EmailAdapter implements NotificationService{

    private LegacyEmailService legacyEmail;

    public EmailAdapter(){

        legacyEmail = new LegacyEmailService();

    }

    @Override
    public void sendNotification(String message) {

        legacyEmail.sendMail(message);

    }

}