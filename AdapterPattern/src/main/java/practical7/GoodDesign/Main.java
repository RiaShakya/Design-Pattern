package practical7.GoodDesign;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Report report = new StudentReport();

        System.out.print("Add PDF? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            report = new PdfDecorator(report);
        }

        System.out.print("Add Watermark? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            report = new WatermarkDecorator(report);
        }

        System.out.print("Add Signature? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            report = new SignatureDecorator(report);
        }

        System.out.println();
        report.generate();

    }

}