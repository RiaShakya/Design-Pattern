package practical4.GoodDesign;

public class NotificationSystem {

    private final NotificationService notificationService;

    public NotificationSystem(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyStudent(String message) {

        notificationService.sendNotification(message);

    }

}
