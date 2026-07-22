package practical7;

import org.junit.jupiter.api.Test;
import practical7.GoodDesign.*;

import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {

    @Test
    void basicReport() {

        Report report = new StudentReport();

        assertDoesNotThrow(report::generate);

    }

    @Test
    void pdfWorks() {

        Report report =
                new PdfDecorator(new StudentReport());

        assertDoesNotThrow(report::generate);

    }

    @Test
    void watermarkWorks() {

        Report report =
                new WatermarkDecorator(new StudentReport());

        assertDoesNotThrow(report::generate);

    }

    @Test
    void signatureWorks() {

        Report report =
                new SignatureDecorator(new StudentReport());

        assertDoesNotThrow(report::generate);

    }

    @Test
    void reportNotNull() {

        Report report =
                new SignatureDecorator(
                        new WatermarkDecorator(
                                new PdfDecorator(
                                        new StudentReport())));

        assertNotNull(report);

    }

}