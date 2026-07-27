package practical10.BadDesign;

public class StudentPortal {

    public void requestService(String service) {

        if (service.equalsIgnoreCase("Transcript")) {

            System.out.println("Transcript Request Submitted");

        } else if (service.equalsIgnoreCase("Certificate")) {

            System.out.println("Certificate Request Submitted");

        } else if (service.equalsIgnoreCase("ID Card")) {

            System.out.println("ID Card Request Submitted");

        } else if (service.equalsIgnoreCase("Library Card")) {

            System.out.println("Library Card Request Submitted");

        } else {

            System.out.println("Invalid Request");

        }

    }

}
