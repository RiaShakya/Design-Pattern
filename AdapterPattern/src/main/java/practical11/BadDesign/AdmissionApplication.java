package practical11.BadDesign;

public class AdmissionApplication {

    public void changeStatus(String status) {

        if (status.equalsIgnoreCase("Submitted")) {

            System.out.println("Application Submitted");

        } else if (status.equalsIgnoreCase("Verified")) {

            System.out.println("Application Verified");

        } else if (status.equalsIgnoreCase("Approved")) {

            System.out.println("Application Approved");

        } else if (status.equalsIgnoreCase("Enrolled")) {

            System.out.println("Student Enrolled");

        } else if (status.equalsIgnoreCase("Rejected")) {

            System.out.println("Application Rejected");

        } else {

            System.out.println("Invalid Status");

        }

    }

}
