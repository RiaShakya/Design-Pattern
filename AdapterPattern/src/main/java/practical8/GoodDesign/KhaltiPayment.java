package practical8.GoodDesign;

public class KhaltiPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("Rs. " + amount + " paid using Khalti.");

    }

}
