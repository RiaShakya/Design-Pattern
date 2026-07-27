package TestCases;

import org.junit.jupiter.api.Test;
import state.AvailableState;
import state.BookContext;
import state.IssuedState;
import state.ReturnedState;

import static org.junit.jupiter.api.Assertions.*;

class BookStateTest {

    @Test
    void testStateTransition() {

        BookContext context = new BookContext();

        context.setState(new AvailableState());

        assertNotNull(context);

        context.setState(new IssuedState());

        context.setState(new ReturnedState());

    }

}
