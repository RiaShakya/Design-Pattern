package practical6.GoodDesign;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter role (ADMIN/STUDENT): ");
        String role = sc.nextLine();

        StudentRecord record =
                new StudentRecordProxy(role);

        record.viewMarks();

    }

}