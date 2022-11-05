package menu;

import shop_item.User;
import shop_item.UserBills;
import shop_item.UserCart;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private final GuestMenu guestMenu;
    private final UserMenu userMenu;
    private final AdminMenu adminMenu;
    public MainMenu() {
        guestMenu = new GuestMenu();
        userMenu = new UserMenu();
        adminMenu = new AdminMenu();
    }
    public void runMainMenu(Scanner scanner, Resource resource) {
        String string;
        int choice = -1;
        while (true) {
            resource.printer.menu.printHomePageMenu();
            string = scanner.nextLine();
            if (resource.input.validate.validateHomePageChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    guestMenu.runGuestMenu(scanner, resource);
                    break;
                case 2:
                    printLoginMenu(scanner, resource);
                    break;
                case 3:
                    printSignupMenu(scanner, resource);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    public void printLoginMenu(Scanner scanner, Resource resource) {
        String string;
        int choice = -1;
        boolean check = true;
        List<User> users = resource.manager.user.getUsers();
        while (check) {
            resource.printer.menu.printLoginMenu();
            string = scanner.nextLine();
            if (resource.input.validate.validateLoginChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    String[] data = resource.input.loginAndUserInput.logInInput(scanner);
                    if (data[0].equals("") || data[1].equals("")) {
                        resource.printer.error.fillUsernameAndPassword();
                    } else {
                        if (resource.input.loginAndUserInput.validateUser(data, users)) {
                            resource.printer.success.loginSuccessfully();
                            User user = resource.manager.user.getUserByName(data[0]);
                            userMenu.runUserMenu(scanner, resource, user);
                        } else if (resource.input.loginAndUserInput.validateAdmin(data, users)) {
                            resource.printer.success.loginSuccessfully();
                            adminMenu.runAdminMenu(scanner, resource);
                        } else {
                            resource.printer.error.loginFail();
                        }
                    }
                    break;
                case 2:
                    String email = resource.input.loginAndUserInput.forgotPassword(scanner);
                    if (resource.input.validate.validateEmail(email)) {
                        User user = new User();
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
                            resource.printer.notification.sendEmailContainPassWord(user);
                            break;
                        } else {
                            resource.printer.error.emailNotFound();
                        }
                    } else {
                        resource.printer.notification.pleaseFillEmail();
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void printSignupMenu(Scanner scanner, Resource resource) {
        String string;
        int choice = -1;
        boolean check = true;
        while (check) {
            resource.printer.menu.printSignupMenu();
            string = scanner.nextLine();
            if (resource.input.validate.validateSignupChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    String[] data = resource.input.loginAndUserInput.logInInput(scanner);
                    if (data[0].equals("") || data[1].equals("")) {
                        resource.printer.notification.pleaseFillUsernameAndPassword();
                    } else {
                        if (resource.input.loginAndUserInput.checkExistUserName(data[0], resource)) {
                            resource.printer.error.userNameExist();
                        } else {
                            User newUser = new User(data[0], data[1]);
                            UserCart userCart = new UserCart(newUser);
                            UserBills userBills = new UserBills(newUser);
                            resource.manager.user.add(newUser);
                            resource.manager.cart.add(userCart);
                            resource.manager.bill.add(userBills);
                            resource.printer.success.signupSuccessfully();
                        }
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
