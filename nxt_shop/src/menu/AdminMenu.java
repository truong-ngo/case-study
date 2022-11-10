package menu;

import manager.Manager;
import product.Product;
import shop_item.ChatSession;
import shop_item.Messenger;
import shop_item.User;
import shop_item.UserBills;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class AdminMenu extends AbstractMenu {
    private static AdminMenu instance;

    private AdminMenu() {

    }

    public static AdminMenu getInstance() {
        if (instance == null) {
            instance = new AdminMenu();
        }
        return instance;
    }

    public void runAdminMenu(Scanner scanner, Manager manager) {
        boolean check = true;
        int id;
        while (check) {
            int choice = -1;
            printer.menu.printAdminPage();
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 7)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.invalidData("choice");
            }
            switch (choice) {
                case 1:
                    runAddProductMenu(scanner, manager);
                    break;
                case 2:
                    id = input.product.inputId(scanner, printer, input, manager);
                    if (id != -1) {
                        if (manager.product.getProducts().isEmpty()) {
                            printer.notification.itemIsEmpty("Product list");
                        } else {
                            Product product = input.product.inputUpdateProduct(id, scanner, printer, input, manager);
                            manager.product.update(id, product);
                            manager.product.setStaticNumber();
                            printer.success.actionSuccessfully("Update");
                        }
                    }
                    break;
                case 3:
                    id = input.product.inputId(scanner, printer, input, manager);
                    if (id != -1) {
                        manager.product.delete(id);
                        manager.product.setStaticNumber();
                        printer.success.actionSuccessfully("Delete");
                    }
                    break;
                case 4:
                    manager.product.displayAll(printer);
                    break;
                case 5:
                    GuestMenu guest = GuestMenu.getInstance();
                    guest.runSearch(scanner, manager, "ADMIN");
                    break;
                case 6:
                    manager.product.displayByPrice(printer);
                    break;
                case 7:
                    runUserManager(scanner, manager);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runAddProductMenu(Scanner scanner, Manager manager) {
        boolean check = true;
        while (check) {
            int choice = -1;
            printer.menu.printAddProduct();
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 3)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.invalidData("choice");
            }
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    Product product = input.product.inputAddProduct(scanner, printer, input, manager, choice);
                    manager.product.add(product);
                    printer.success.actionSuccessfully("Add");
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runUserManager(Scanner scanner, Manager manager) {
        boolean check = true;
        while (check) {
            int choice = -1;
            printer.menu.printUserManager();
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 5)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.invalidData("choice");
            }
            switch (choice) {
                case 1:
                    List<User> users = manager.user.getUsers();
                    printer.table.printUserList(users);
                    break;
                case 2:
                    String username = input.user.inputItem(scanner, printer, "username");
                    if (username == null) {
                        printer.error.pleaseEnterData("username");
                    } else {
                        if (manager.user.checkExistUsername(username)) {
                            User user = manager.user.getUserByName(username);
                            UserBills userBills = manager.bill.getUserBillsByUser(user);
                            printer.table.printListBills(userBills, user, "list bills");
                        } else {
                            printer.error.itemNotFound("Username");
                        }
                    }
                    break;
                case 3:
                    int totalIncome = manager.bill.getTotalIncome();
                    printer.notification.totalIncomeDisplay(totalIncome);
                    break;
                case 4:
                    manager.user.readUserList();
                    User admin = manager.user.getAdmin();
                    printer.table.printNotification(admin);
                    break;
                case 5:
                    manager.user.readUserList();
                    manager.chat.readSessionList();
                    admin = manager.user.getAdmin();
                    printer.inputBox.printInputBox("username");
                    String name = scanner.nextLine();
                    User user = manager.user.getUserByName(name);
                    if (user != null) {
                        runChatSession(scanner, manager, admin, user);
                    } else {
                        printer.error.itemNotFound("User");
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runChatSession(Scanner scanner, Manager manager, User userOne, User userTwo) {
        boolean check = true;
        while (check) {
            manager.chat.readSessionList();
            ChatSession chatSession = manager.chat.getSessionByUsers(userOne, userTwo);
            printer.table.printChatBox(userOne, userTwo, chatSession);
            int choice = -1;
            printer.menu.printChat(userOne);
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 2)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.invalidData("choice");
            }
            switch (choice) {
                case 1:
                    printer.chat.enterMessage();
                    String message = scanner.nextLine();
                    String notifyMess = input.bill.notificationFromUser(userOne);
                    if (!message.equals("")) {
                        LocalDateTime time = LocalDateTime.now();
                        message = userOne.getUsername() + ": " + message;
                        Messenger messenger = new Messenger(message, time);
                        messenger.setMessID(userOne);
                        chatSession.addMessenger(messenger);
                        Messenger notify = new Messenger(notifyMess, time);
                        notify.setMessID(userOne);
                        userTwo.addNotification(notify);
                        manager.user.saveUserList();
                        printer.success.actionSuccessfully("Sent message");
                    } else {
                        printer.error.actionFailed("Sent message");
                    }
                    manager.chat.saveSessionList();
                    manager.user.saveUserList();
                    break;
                case 2:
                    manager.chat.readSessionList();
                    manager.user.readUserList();
                    userOne = manager.user.getUserByName(userOne.getUsername());
                    userTwo = manager.user.getUserByName(userTwo.getUsername());
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
