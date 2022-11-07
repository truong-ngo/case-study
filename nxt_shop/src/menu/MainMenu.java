package menu;

import manager.Manager;
import shop_item.User;
import shop_item.UserBills;
import shop_item.UserCart;
import java.util.List;
import java.util.Scanner;

public class MainMenu extends AbstractMenu {
    private final GuestMenu guestMenu;
    private final UserMenu userMenu;
    private final AdminMenu adminMenu;
    public MainMenu() {
        guestMenu = new GuestMenu();
        userMenu = new UserMenu();
        adminMenu = new AdminMenu();
    }
    public void run(Scanner scanner, Manager manager) {
        String string;
        while (true) {
            int choice = -1;
            printer.menu.printHomePage();
            string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 3)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    guestMenu.run(scanner, manager);
                    break;
                case 2:
                    runLoginMenu(scanner, manager);
                    break;
                case 3:
                    runSignupMenu(scanner, manager);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    public void runLoginMenu(Scanner scanner, Manager manager) {
        String string;
        boolean check = true;
        List<User> users = manager.user.getUsers();
        while (check) {
            int choice = -1;
            printer.menu.printLogin();
            string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 2)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    String[] data = input.user.userInput(scanner, printer);
                    if (data != null) {
                        if (manager.user.checkUser(data)) {
                            printer.success.loginSuccessfully();
                            User user = manager.user.getUserByName(data[0]);
                            userMenu.run(scanner, manager, user);
                        } else if (manager.user.checkAdmin(data)) {
                            printer.success.loginSuccessfully();
                            adminMenu.runAdminMenu(scanner, manager);
                        } else {
                            printer.error.incorrectData("username or password");
                        }
                    } else {
                        printer.error.pleaseEnterData("username and password");
                    }
                    break;
                case 2:
                    String email = input.user.inputItem(scanner, printer, "email");
                    if (email == null) {
                        printer.error.pleaseEnterData("email");
                    } else {
                        if (input.validate.validateEmail(email)) {
                            User user = new User();
                            if (manager.user.checkDuplicateEmail(email)) {
                                for (User u : users) {
                                    if (u.getEmail() == null) {
                                        continue;
                                    }
                                    if (u.getEmail().equals(email)) {
                                        user = u;
                                        break;
                                    }
                                }
                                printer.notification.sendEmailContainPassword(user);
                                break;
                            } else {
                                printer.error.itemNotFound("email");
                            }
                        } else {
                            printer.error.invalidData("email");
                        }
                    }

                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runSignupMenu(Scanner scanner, Manager manager) {
        String string;
        boolean check = true;
        while (check) {
            int choice = -1;
            printer.menu.printSignup();
            string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 1)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    String[] userInput = input.user.userInput(scanner, printer);
                    if (userInput == null) {
                        printer.error.pleaseEnterData("username and input");
                    } else {
                        if (manager.user.checkExistUsername(userInput[0])) {
                            printer.error.itemAlreadyExist("Username");
                        } else {
                            User newUser = new User(userInput[0], userInput[1]);
                            UserCart userCart = new UserCart(newUser);
                            UserBills userBills = new UserBills(newUser);
                            manager.user.add(newUser);
                            manager.cart.add(userCart);
                            manager.bill.add(userBills);
                            printer.success.actionSuccessfully("Signup");
                        }
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
