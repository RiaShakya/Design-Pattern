package proxy;

public class RealLibraryRecord implements LibraryRecord {

    @Override
    public void accessRecord() {

        System.out.println("======================================");
        System.out.println("LIBRARY RECORD ACCESS");
        System.out.println("======================================");
        System.out.println();
        System.out.println("Library records opened successfully.");

    }

}