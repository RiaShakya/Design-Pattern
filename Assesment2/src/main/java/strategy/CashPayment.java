package strategy;

public class CashPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("Payment Method : Cash");
        System.out.println("Amount Paid : NPR " + amount);

    }

}