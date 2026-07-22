package practical4.BadDesign;

public class LegacyEmailService {

    public void sendOldEmail(String receiver, String message) {
        System.out.println("Legacy Email sent to " + receiver);
        System.out.println("Message: " + message);
    }
}