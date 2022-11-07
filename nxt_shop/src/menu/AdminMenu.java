package menu;

import manager.Manager;
import product.Product;
import shop_item.User;
import shop_item.UserBills;

import java.util.List;
import java.util.Scanner;

public class AdminMenu extends AbstractMenu {
    public void runAdminMenu(Scanner scanner, Manager manager) {
        boolean check = true;
        int id;
        while (check) {
            int choice = -1;
            printer.menu.printAdminPage();
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 6)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    runAddProductMenu(scanner, manager);
                    break;
                case 2:
                    id = input.product.inputId(scanner, printer, input, manager);
                    if (id != -1) {
                        if (manager.product.getProducts().isEmpty()) {
                            printer.notification.listIsEmpty("Product list");
                            // check empty list
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
                    manager.product.displayByPrice(printer);
                    break;
                case 6:
                    runUserManagerMenu(scanner, manager);
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
                printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    Product product = input.product.inputAddProduct(scanner, printer, input, manager, choice);
                    manager.product.add(product);
                    printer.success.addSuccessfully();
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runUserManagerMenu(Scanner scanner, Manager manager) {
        boolean check = true;
        while (check) {
            int choice = -1;
            printer.menu.printUserManager();
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 3)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.reChoice();
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
                            printer.table.printBill(userBills, user, "bill");
                        } else {
                            printer.error.itemNotFound("Username");
                        }
                    }
                    break;
                case 3:
                    int totalIncome = manager.bill.getTotalIncome();
                    printer.notification.totalIncomeDisplay(totalIncome);
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
