package decorator;

public class BasicReceipt implements Receipt {

    private final String memberCode;
    private final String bookTitle;

    public BasicReceipt(String memberCode, String bookTitle) {

        this.memberCode = memberCode;
        this.bookTitle = bookTitle;

    }

    @Override
    public String print() {

        return "===== BORROW RECEIPT =====\n"
                + "Member : " + memberCode + "\n"
                + "Book   : " + bookTitle;

    }

}