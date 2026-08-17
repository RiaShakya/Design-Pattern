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

        Receipt receipt = new BasicReceipt("M001", "Atomic Habits");

        receipt = new DateDecorator(receipt);

        receipt = new QRCodeDecorator(receipt);

        String output = receipt.print();

        assertTrue(output.contains("BORROW RECEIPT"));
        assertTrue(output.contains("M001"));
        assertTrue(output.contains("Atomic Habits"));
        assertTrue(output.contains("Issue Date"));
        assertTrue(output.contains("Due Date"));
        assertTrue(output.contains("QR Code"));
    }

}