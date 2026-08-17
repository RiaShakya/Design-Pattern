package TestCases;

import command.BorrowHistoryCommand;
import command.FineReceiptCommand;
import command.LibraryServiceInvoker;
import command.MembershipCardCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryCommandTest {

    @Test
    void testCommands() {

        LibraryServiceInvoker invoker =
                new LibraryServiceInvoker();

        invoker.execute(new BorrowHistoryCommand());

        invoker.execute(new FineReceiptCommand());

        invoker.execute(new MembershipCardCommand());

        assertNotNull(invoker);
    }

}
