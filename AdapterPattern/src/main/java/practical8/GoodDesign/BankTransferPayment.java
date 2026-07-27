package practical8.GoodDesign;

public class BankTransferPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("Rs. " + amount + " paid using Bank Transfer.");

    }

}