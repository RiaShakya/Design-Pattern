package practical8;

import org.junit.jupiter.api.Test;
import practical8.GoodDesign.BankTransferPayment;
import practical8.GoodDesign.EsewaPayment;
import practical8.GoodDesign.KhaltiPayment;
import practical8.GoodDesign.PaymentContext;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {

    @Test
    void khaltiWorks() {

        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new KhaltiPayment());

        context.makePayment(50000);

        assertNotNull(context);

    }

    @Test
    void esewaWorks() {

        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new EsewaPayment());

        context.makePayment(50000);

        assertNotNull(context);

    }

    @Test
    void bankWorks() {

        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new BankTransferPayment());

        context.makePayment(50000);

        assertNotNull(context);

    }

    @Test
    void contextNotNull() {

        PaymentContext context = new PaymentContext();

        assertNotNull(context);

    }

}