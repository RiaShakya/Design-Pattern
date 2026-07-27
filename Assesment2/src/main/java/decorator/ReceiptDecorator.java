package decorator;

public abstract class ReceiptDecorator implements Receipt{

    protected Receipt receipt;

    public ReceiptDecorator(Receipt receipt){

        this.receipt=receipt;

    }

}