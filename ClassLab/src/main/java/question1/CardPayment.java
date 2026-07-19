package question1;

public class CardPayment implements Payment{

    @Override
    public void pay(double amount){
        System.out.println("Paid using Card: " + amount);
    }
}
