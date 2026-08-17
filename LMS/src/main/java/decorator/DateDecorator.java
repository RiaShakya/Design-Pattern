package decorator;

import java.time.LocalDate;

public class DateDecorator extends ReceiptDecorator{

    private final LocalDate issueDate;
    private final LocalDate dueDate;

    public DateDecorator(Receipt receipt){

        super(receipt);

        // Same 3-day borrowing period used when the borrow record is saved.
        this.issueDate = LocalDate.now();
        this.dueDate = issueDate.plusDays(3);

    }

    @Override
    public String print() {

        return receipt.print()
                + "\nIssue Date : " + issueDate
                + "\nDue Date   : " + dueDate + " (3 days from issue)";

    }

}