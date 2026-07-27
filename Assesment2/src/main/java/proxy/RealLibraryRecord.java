package proxy;

public class RealLibraryRecord implements LibraryRecord{

    @Override
    public void accessRecord() {

        System.out.println("Library records opened.");

    }

}