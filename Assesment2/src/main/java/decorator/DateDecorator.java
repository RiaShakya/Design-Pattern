package decorator;

public class DateDecorator extends ReceiptDecorator{

    public DateDecorator(Receipt receipt){

        super(receipt);

    }

    @Override
    public String print() {

        return receipt.print()
                + "\nIssue Date Added";

    }

}