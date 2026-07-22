package practical4.GoodDesign;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter notification message: ");
        String message = sc.nextLine();

        LegacyEmailService legacyEmailService = new LegacyEmailService();

        NotificationService adapter =
                new EmailAdapter(legacyEmailService);

        NotificationSystem notificationSystem =
                new NotificationSystem(adapter);

        notificationSystem.notifyStudent(message);

    }

}