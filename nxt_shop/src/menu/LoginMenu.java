package menu;

import user.Cart;
import user.User;

import java.util.List;
import java.util.Scanner;

public class LoginMenu {
    private final UserMenu userMenu;

    public LoginMenu() {
        userMenu = new UserMenu();
    }
    public void displayLoginMenu(Scanner scanner, Resource resource) {
        String string;
        int choice = -1;
        boolean check = true;
        List<User> users = resource.manager.getUserManager().getUsers();
        while (check) {
            resource.printer.loginMenuPrinter.printSignInMenu();
            string = scanner.nextLine();
            if (resource.input.validate.validateLoginChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String[] data = resource.input.loginAndUserInput.logInInput(scanner);
                    User admin = resource.manager.getUserManager().getADMIN();
                    if (resource.input.loginAndUserInput.validateUser(data, users)) {
                        resource.printer.loginMenuPrinter.logInSuccessful();
                        User user = resource.manager.getUserManager().getUserByName(data[0]);
                        userMenu.runUserMenu(scanner, resource, user);
                    } else if (resource.input.loginAndUserInput.validateAdmin(data, users)) {
                        resource.printer.loginMenuPrinter.logInSuccessful();
                        // Run admin menu
                    } else {
                        resource.printer.loginMenuPrinter.logInFail();
                    }
                    break;
                case 2:
                    String email = resource.input.loginAndUserInput.forgotPassword(scanner);
                    User user = null;
                    if (resource.input.loginAndUserInput.checkDuplicateEmail(email, users)) {
                        for (User u : users) {
                            if (u.getEmail() == null) {
                                continue;
                            }
                            if (u.getEmail().equals(email)) {
                                user = u;
                                break;
                            }
                        }
                        resource.printer.loginMenuPrinter.sendEmailContainPassWord(user);
                        break;
                    } else {
                        resource.printer.loginMenuPrinter.emailNotFound();
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
            if (resource.input.validate.validateSignupChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String[] data = resource.input.loginAndUserInput.logInInput(scanner);
                    if (resource.input.loginAndUserInput.checkExistUserName(data[0], resource)) {
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
