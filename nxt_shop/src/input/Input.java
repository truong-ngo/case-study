package input;

import menu.Resource;

import java.util.Scanner;

public class Input {
    public static String inputStringData(Scanner scanner, String type) {
        System.out.println("⌨ Enter " + type + ": ");
        return scanner.nextLine();
    }

    public static String inputNumberData(Resource resource, Scanner scanner, String type) {
        String string = null;
        boolean check = true;
        while (check) {
            System.out.println("⌨ Enter " + type + ": ");
            string = scanner.nextLine();
            if (resource.input.validate.validateNumber(string) || string.equals("")) {
                check = false;
            } else {
                resource.printer.error.invalidData();
            }
        }
        return string;
    }

    public static int getNumberData(Resource resource, Scanner scanner, String type) {
        String string;
        int count = 0;
        while (true) {
            string = inputNumberData(resource, scanner, type);
            if (!string.equals("")) {
                return Integer.parseInt(string);
            }
            if (count >= 0) {
                resource.printer.error.invalidData();
            }
            count++;
        }
    }
}
