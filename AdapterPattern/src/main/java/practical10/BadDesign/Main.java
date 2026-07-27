package practical10.BadDesign;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentPortal portal = new StudentPortal();

        System.out.print("Enter Request: ");
        String request = sc.nextLine();

        portal.requestService(request);

    }

}
