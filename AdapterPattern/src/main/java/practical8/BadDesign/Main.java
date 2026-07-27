package practical8.BadDesign;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Payment Method: ");
        String method = sc.nextLine();

        FeePayment payment = new FeePayment();

        payment.pay(method);

    }

}
