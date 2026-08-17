package command;

public class FineReceiptCommand implements Command {

    @Override
    public void execute() {

        System.out.println("Fine Receipt Generated.");

    }

}