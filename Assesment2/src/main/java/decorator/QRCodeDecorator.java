package decorator;

public class QRCodeDecorator extends ReceiptDecorator{

    public QRCodeDecorator(Receipt receipt){

        super(receipt);

    }

    @Override
    public String print() {

        return receipt.print()
                + "\nQR Code Added";

    }

}