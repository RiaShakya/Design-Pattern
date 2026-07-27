package strategy;

public class EsewaPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("Payment Method : eSewa");
        System.out.println("Amount Paid : NPR " + amount);

    }

}