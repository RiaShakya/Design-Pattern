package decorator;

public class BasicReceipt implements Receipt{

    @Override
    public String print() {

        return "Borrow Receipt";

    }

}