package practical5.GoodDesign;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        StudentRegistrationFacade facade =
                new StudentRegistrationFacade();

        facade.registerStudent(name);

    }

}
