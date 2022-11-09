package input;

import printer.Printer;
import shop_item.User;

import java.util.Scanner;

public class UserInput {
    public String[] userInput(Scanner scanner, Printer printer) {
        printer.inputBox.printInputBox("username");
        String userName = scanner.nextLine();
        printer.inputBox.printInputBox("password");
        String password = scanner.nextLine();
        if (userName.equals("") || password.equals("")) {
            return null;
        }
        return new String[]{userName, password};
    }

    public String[] userInformationInput(Scanner scanner, Printer printer, Input input, User user) {
        printer.inputBox.printInputBox("new email (email format is xxx@gmail.com, begin with letter)");
        String email = scanner.nextLine();
        printer.inputBox.printInputBox("new phone number (10 number, begin with 0 followed by 3 or 5 or 7 or 8 or 9)");
        String phoneNumber = scanner.nextLine();
        printer.inputBox.printInputBox("new address");
        String address = scanner.nextLine();
        if ((input.validate.validatePhoneNumber(phoneNumber) || phoneNumber.equals("")) &&
            (input.validate.validateEmail(email) || email.equals(""))) {
            if (email.equals("") && phoneNumber.equals("") && address.equals("")) {
                return null;
            } else {
                if (email.equals("")) {
                    email = user.getEmail();
                }
                if (phoneNumber.equals("")) {
                    phoneNumber = user.getPhoneNumber();
                }
                if (address.equals("")) {
                    address = user.getAddress();
                }
                return new String[]{email, phoneNumber, address};
            }
        } else {
            return new String[0];
        }
    }

    public String inputItem(Scanner scanner, Printer printer, String item) {
        printer.inputBox.printInputBox(item);
        String data = scanner.nextLine();
        if (data.equals("")) {
            return null;
        }
        return data;
    }
}
