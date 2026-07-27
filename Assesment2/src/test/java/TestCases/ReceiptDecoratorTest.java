package TestCases;

import decorator.BasicReceipt;
import decorator.DateDecorator;
import decorator.QRCodeDecorator;
import decorator.Receipt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptDecoratorTest {

    @Test
    void testReceiptDecoration() {

        Receipt receipt = new BasicReceipt();

        receipt = new DateDecorator(receipt);

        receipt = new QRCodeDecorator(receipt);

        String output = receipt.print();

        assertTrue(output.contains("Borrow Receipt"));
        assertTrue(output.contains("Issue Date"));
        assertTrue(output.contains("QR Code"));
    }

}
