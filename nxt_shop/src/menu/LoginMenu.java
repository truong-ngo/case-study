package menu;

import user.Cart;
import user.User;

import java.util.Scanner;

public class LoginMenu {
    private final UserMenu userMenu;

    public LoginMenu() {
        userMenu = new UserMenu();
    }
    public void displayLoginMenu(Scanner scanner, Resource resource) {
        String str;
        int choice = -1;
        boolean check = true;
        while (check) {
            resource.printer.loginMenuPrinter.printSignInMenu();
            str = scanner.nextLine();
            if (resource.input.validateMenuChoice.validateLoginChoice(str)) {
                choice = Integer.parseInt(str);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String[] data = resource.input.loginInput.logInInput(scanner);
                    if (resource.input.loginInput.validateUser(data, resource.manager.getUserManager().getUsers())) {
                        resource.printer.loginMenuPrinter.logInSuccessful();
                        User user = resource.manager.getUserManager().getUserByName(data[0]);
                        userMenu.runUserMenu(scanner, resource, user);
                    } else {
                        resource.printer.loginMenuPrinter.logInFail();
                    }
                    break;
                case 2:
                    String[] dataAdmin = resource.input.loginInput.logInInput(scanner);
                    User admin = resource.manager.getUserManager().getADMIN();
                    if (resource.input.loginInput.validateAdmin(dataAdmin, admin)) {
                        resource.printer.loginMenuPrinter.logInSuccessful();
                        // admin menu
                    } else {
                        resource.printer.loginMenuPrinter.logInFail();
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void displaySignUpMenu(Scanner scanner, Resource resource) {
        String string;
        int choice = -1;
        boolean check = true;
        while (check) {
            resource.printer.loginMenuPrinter.printSignUpMenu();
            string = scanner.nextLine();
            if (resource.input.validateMenuChoice.validateLoginChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String[] data = resource.input.loginInput.logInInput(scanner);
                    if (resource.input.loginInput.checkExistUserName(data[0], resource)) {
                        resource.printer.loginMenuPrinter.userNameExist();
                    } else {
                        User newUser = new User(data[0], data[1]);
                        Cart newCart = new Cart(newUser);
                        resource.manager.getUserManager().add(newUser);
                        resource.manager.getCartManager().add(newCart);
                        resource.printer.loginMenuPrinter.signUpSuccessful();
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
