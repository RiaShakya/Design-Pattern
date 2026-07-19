package question1;

public class EsewaPayment implements Payment{
    @Override
    public void pay(double amount){
        System.out.println("Paid using Esewa: " + amount );
    }
}
