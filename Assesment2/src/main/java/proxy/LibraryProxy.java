package proxy;

public class LibraryProxy implements LibraryRecord{

    private String role;

    private RealLibraryRecord realRecord;

    public LibraryProxy(String role){

        this.role = role;

    }

    @Override
    public void accessRecord() {

        if(role.equalsIgnoreCase("LIBRARIAN")){

            if(realRecord==null)
                realRecord=new RealLibraryRecord();

            realRecord.accessRecord();

        }

        else{

            System.out.println("Access Denied.");

        }

    }

}