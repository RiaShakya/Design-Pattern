package practical10.GoodDesign;

public class StudentPortal {

    private RequestCommand command;

    public void setCommand(RequestCommand command) {

        this.command = command;

    }

    public void submitRequest() {

        command.execute();

    }

}
