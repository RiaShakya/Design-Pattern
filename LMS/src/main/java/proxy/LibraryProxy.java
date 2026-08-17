package proxy;

public class LibraryProxy implements LibraryRecord {

    private final String role;
    private RealLibraryRecord realRecord;

    public LibraryProxy(String role) {

        this.role = role;

    }

    @Override
    public void accessRecord() {

        if (role == null) {

            System.out.println("Invalid Login.");
            return;

        }

        switch (role.toUpperCase()) {

            case "ADMIN":

                if (realRecord == null)
                    realRecord = new RealLibraryRecord();

                System.out.println("Admin Access Granted.");
                System.out.println();
                realRecord.accessRecord();
                break;

            case "LIBRARIAN":

                if (realRecord == null)
                    realRecord = new RealLibraryRecord();

                System.out.println("Librarian Access Granted.");
                System.out.println();

                realRecord.accessRecord();
                break;

            case "MEMBER":


                System.out.println("Member Access Granted.");
                System.out.println();
                System.out.println("Members can borrow, return and view their own records.");
                break;

            default:

                System.out.println();
                System.out.println("Access Denied.");

        }

    }

}