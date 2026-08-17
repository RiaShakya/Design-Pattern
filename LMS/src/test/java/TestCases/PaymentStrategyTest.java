package TestCases;

import org.junit.jupiter.api.Test;
import strategy.CardPayment;
import strategy.CashPayment;
import strategy.PaymentContext;

import static org.junit.jupiter.api.Assertions.*;

class PaymentStrategyTest {

    @Test
    void testCashPayment() {

        PaymentContext context = new PaymentContext();

        context.setStrategy(new CashPayment());

        assertNotNull(context);
    }

    @Test
    void testCardPayment() {

        PaymentContext context = new PaymentContext();

        context.setStrategy(new CardPayment());

        assertNotNull(context);
    }

}
