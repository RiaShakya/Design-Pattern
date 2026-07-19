package question1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class PaymentSystemTest {

    @Test
    void testEsewaPayment() {

        PaymentSystem paymentSystem =
                new PaymentSystem(new EsewaPayment());

        assertDoesNotThrow(() ->
                paymentSystem.makePayment(1000));
    }

    @Test
    void testKhaltiPayment() {

        PaymentSystem paymentSystem =
                new PaymentSystem(new KhaltiPayment());

        assertDoesNotThrow(() ->
                paymentSystem.makePayment(2000));
    }

    @Test
    void testCardPayment() {

        PaymentSystem paymentSystem =
                new PaymentSystem(new CardPayment());

        assertDoesNotThrow(() ->
                paymentSystem.makePayment(3000));
    }

}
