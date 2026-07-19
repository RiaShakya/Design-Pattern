package question1;

public class PaymentSystem {

    private Payment payment;

    public PaymentSystem(Payment payment) {
        this.payment = payment;
    }

    public void makePayment(double amount) {
        payment.pay(amount);
    }

    public static void main(String[] args) {

        PaymentSystem esewa =
                new PaymentSystem(new EsewaPayment());

        PaymentSystem khalti =
                new PaymentSystem(new KhaltiPayment());

        PaymentSystem card =
                new PaymentSystem(new CardPayment());

        esewa.makePayment(1000);
        khalti.makePayment(2000);
        card.makePayment(3000);
    }
}

