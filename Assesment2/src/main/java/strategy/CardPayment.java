package strategy;

public class CardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("Payment Method : Card");
        System.out.println("Amount Paid : NPR " + amount);

    }

}