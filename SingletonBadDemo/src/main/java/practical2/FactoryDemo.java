package practical2;

public class FactoryDemo {

    public static void main(String[] args) {

        NotificationService service = new NotificationService();

        service.sendNotification("EMAIL", "Assignment uploaded");
        service.sendNotification("SMS", "Exam starts tomorrow");
        service.sendNotification("PUSH", "New notice published");
    }
}