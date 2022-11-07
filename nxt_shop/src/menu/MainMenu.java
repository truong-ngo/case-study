package menu;

import manager.GeneralManager;
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
    public void run(Scanner scanner, GeneralManager manager) {
        String string;
        int choice = -1;
        while (true) {
            printer.menu.printHomePageMenu();
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

    public void runLoginMenu(Scanner scanner, GeneralManager manager) {
        String string;
        int choice = -1;
        boolean check = true;
        List<User> users = manager.user.getUsers();
        while (check) {
            printer.menu.printLoginMenu();
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
                            printer.error.incorrectData("username and password");
                        }
                    } else {
                        printer.error.pleaseEnterAllData();
                    }
                    break;
                case 2:
                    String email = input.user.inputItem(scanner, printer, "email");
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
                        printer.error.pleaseEnterAllData();
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runSignupMenu(Scanner scanner, GeneralManager manager) {
        String string;
        int choice = -1;
        boolean check = true;
        while (check) {
            printer.menu.printSignupMenu();
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
                        printer.error.pleaseEnterAllData();
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
