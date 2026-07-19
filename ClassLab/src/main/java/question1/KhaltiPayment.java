package question1;

public class KhaltiPayment implements Payment{

    @Override
    public void pay(double amount) {
        System.out.println("Paid using Khalti: " + amount);
    }

}
