package menu;

import manager.Manager;
import shop_item.ChatSession;
import shop_item.User;
import shop_item.UserBills;
import shop_item.Cart;
import java.util.List;
import java.util.Scanner;

public class MainMenu extends AbstractMenu {
    private final GuestMenu guest;
    private final UserMenu user;
    private final AdminMenu admin;
    public MainMenu() {
        guest = GuestMenu.getInstance();
        user = UserMenu.getInstance();
        admin = AdminMenu.getInstance();
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
                printer.error.invalidData("choice");
            }
            switch (choice) {
                case 1:
                    guest.run(scanner, manager);
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
                printer.error.invalidData("choice");
            }
            switch (choice) {
                case 1:
                    String[] data = input.user.userInput(scanner, printer);
                    if (data != null) {
                        if (manager.user.checkUser(data)) {
                            printer.success.actionSuccessfully("Login");
                            User user = manager.user.getUserByName(data[0]);
                            this.user.run(scanner, manager, user);
                        } else if (manager.user.checkAdmin(data)) {
                            printer.success.actionSuccessfully("Login");
                            admin.runAdminMenu(scanner, manager);
                        } else {
                            printer.error.incorrectData("username or password");
                        }
                    } else {
                        printer.error.pleaseEnterData("username and password");
                    }
                    break;
                case 2:
                    String email = input.user.inputItem(scanner, printer, "email (email format is xxx@gmail.com, begin with letter)");
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
                printer.error.invalidData("choice");
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
                            User admin = manager.user.getAdmin();
                            User newUser = new User(userInput[0], userInput[1]);
                            Cart userCart = new Cart(newUser);
                            UserBills userBills = new UserBills(newUser);
                            ChatSession chatSession = new ChatSession(newUser, admin);
                            manager.user.add(newUser);
                            manager.cart.add(userCart);
                            manager.bill.add(userBills);
                            manager.chat.add(chatSession);
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
