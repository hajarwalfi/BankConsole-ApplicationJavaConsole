package util;

import java.util.Scanner;

public class InputUtils {
    private InputUtils() {
    }

    public static int readInt(Scanner scanner, String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Veuillez entre un nombre valide:");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public static double readDouble(Scanner scanner, String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.print("Veuillez entrer un montant valide: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume leftover newline
        return value;
    }

    public static String readString(Scanner scanner, String message) {
        System.out.print(message);
        String input = scanner.nextLine();
        while (input.trim().isEmpty()) {
            System.out.print("Entrée invalide. " + message);
            input = scanner.nextLine();
        }
        return input.trim();
    }
}
