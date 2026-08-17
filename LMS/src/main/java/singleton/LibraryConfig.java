package singleton;

public class LibraryConfig {

    private static LibraryConfig instance;

    private String collegeName;
    private String libraryName;
    private String systemVersion;
    private String librarian;

    private LibraryConfig() {
        collegeName = "PCPS College";
        libraryName = "PCPS Library";
        systemVersion = "1.0";
        librarian = "Mr. Sharma";
    }

    public static LibraryConfig getInstance() {

        if(instance == null)
            instance = new LibraryConfig();

        return instance;
    }

    public String getCollegeName() {
        return collegeName;
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

    public void printConfig() {

        System.out.println("=========================================");
        System.out.println("SINGLETON PATTERN - COLLEGE CONFIGURATION");
        System.out.println("=========================================");
        System.out.println("College Name : " + collegeName);
        System.out.println("System Version: " + systemVersion);

    }
}