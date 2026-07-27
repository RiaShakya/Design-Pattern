package practical8.GoodDesign;

public class EsewaPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("Rs. " + amount + " paid using eSewa.");

    }

}