package practical11.BadDesign;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AdmissionApplication application = new AdmissionApplication();

        System.out.println("Admission Status");
        System.out.println("1. Submitted");
        System.out.println("2. Verified");
        System.out.println("3. Approved");
        System.out.println("4. Enrolled");
        System.out.println("5. Rejected");

        System.out.print("Enter Status: ");
        String status = sc.nextLine();

        application.changeStatus(status);

        sc.close();
    }

}