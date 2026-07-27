package practical8.BadDesign;

public class FeePayment {

    public void pay(String method) {

        if (method.equalsIgnoreCase("Khalti")) {

            System.out.println("Payment Successful using Khalti");

        } else if (method.equalsIgnoreCase("Esewa")) {

            System.out.println("Payment Successful using eSewa");

        } else if (method.equalsIgnoreCase("Bank")) {

            System.out.println("Payment Successful using Bank Transfer");

        } else {

            System.out.println("Invalid Payment Method");

        }

    }

}
