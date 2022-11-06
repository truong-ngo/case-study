package input;

import printer.GeneralPrinter;
import shop_item.User;

import java.util.List;
import java.util.Scanner;

public class UserInput {
    public String[] userInput(Scanner scanner, GeneralPrinter printer) {
        printer.inputBox.printInputBox("username");
        String userName = scanner.nextLine();
        printer.inputBox.printInputBox("password");
        String password = scanner.nextLine();
        if (userName.equals("") || password.equals("")) {
            return null;
        }
        return new String[]{userName, password};
    }

    public String inputItem(Scanner scanner, GeneralPrinter printer, String item) {
        printer.inputBox.printInputBox(item);
        return scanner.nextLine();
    }

    public String updatePassword(Scanner scanner, GeneralPrinter printer) {
        printer.inputBox.printInputBox("new password");
        return scanner.nextLine();
    }

    public String updateEmail(Scanner scanner) {
        System.out.println("⌨ Update email:");
        return scanner.nextLine();
    }

    public String updatePhoneNumber(Scanner scanner) {
        System.out.println("⌨ Update phone number:");
        return scanner.nextLine();
    }

    public String forgotPassword(Scanner scanner) {
        System.out.println("⌨ Enter email:");
        return scanner.nextLine();
    }

    public boolean checkDuplicateEmail(String email, List<User> users) {
        for (User user : users) {
            if (user.getEmail() == null) {
                continue;
            }
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicatePhoneNumber(String phoneNumber, List<User> users) {
        for (User user : users) {
            if (user.getPhoneNumber() == null) {
                continue;
            }
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
