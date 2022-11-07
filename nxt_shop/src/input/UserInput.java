package input;

import printer.GeneralPrinter;
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

    public String[] userInformationInput(Scanner scanner, GeneralPrinter printer, Input input) {
        printer.inputBox.printInputBox("new email");
        String email = scanner.nextLine();
        printer.inputBox.printInputBox("new phone number");
        String phoneNumber = scanner.nextLine();
        if ((input.validate.validatePhoneNumber(phoneNumber) || phoneNumber.equals("")) &&
            (input.validate.validateEmail(email) || email.equals(""))) {
            if (email.equals("") && phoneNumber.equals("")) {
                return null;
            } else {
                return new String[]{email, phoneNumber};
            }
        } else {
            return new String[0];
        }
    }

    public String inputItem(Scanner scanner, GeneralPrinter printer, String item) {
        printer.inputBox.printInputBox(item);
        return scanner.nextLine();
    }
}
