package practical4.GoodDesign;

public class EmailAdapter implements NotificationService {

    private final LegacyEmailService legacyEmailService;

    public EmailAdapter(LegacyEmailService legacyEmailService) {
        this.legacyEmailService = legacyEmailService;
    }

    @Override
    public void sendNotification(String message) {
        legacyEmailService.sendMail(message);
    }
}