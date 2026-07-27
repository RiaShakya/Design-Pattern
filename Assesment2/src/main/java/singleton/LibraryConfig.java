package singleton;

public class LibraryConfig {

    private static LibraryConfig instance;

    private String libraryName;
    private String systemVersion;
    private String librarian;

    private LibraryConfig() {
        libraryName = "PCPS Library";
        systemVersion = "1.0";
        librarian = "Mr. Sharma";
    }

    public static LibraryConfig getInstance() {

        if(instance == null)
            instance = new LibraryConfig();

        return instance;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public String getLibrarian() {
        return librarian;
    }
}