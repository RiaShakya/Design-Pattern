package decorator;

public class QRCodeDecorator extends ReceiptDecorator{

    public QRCodeDecorator(Receipt receipt){

        super(receipt);

    }

    @Override
    public String print() {

        String base = receipt.print();

        // A short, deterministic code derived from this receipt's actual
        // details (member, book, dates) instead of a static placeholder.
        String qrData = "LIB-" + Math.abs(base.hashCode());

        return base
                + "\nQR Code    : [" + qrData + "]";

    }

}