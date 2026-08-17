package service;

import java.util.Scanner;

public class InputHelper {

    // Keeps asking until the user enters a valid whole number.
    public static int readInt(Scanner sc, String prompt) {

        while (true) {

            System.out.print(prompt);

            String input = sc.nextLine();

            try {

                return Integer.parseInt(input.trim());

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a whole number.");

            }

        }

    }

    // Keeps asking until the user enters a valid decimal amount.
    public static double readDouble(Scanner sc, String prompt) {

        while (true) {

            System.out.print(prompt);

            String input = sc.nextLine();

            try {

                return Double.parseDouble(input.trim());

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a valid amount (e.g. 100 or 100.50).");

            }

        }

    }

}