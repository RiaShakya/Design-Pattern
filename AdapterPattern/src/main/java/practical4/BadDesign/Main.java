package practical4.BadDesign;

public class Main {

    public static void main(String[] args) {

        LegacyEmailService service = new LegacyEmailService();

        NotificationSystem system = new NotificationSystem();

        system.sendNotification(service,
                "student@pcps.edu.np",
                "Welcome to PCPS");
    }
}
