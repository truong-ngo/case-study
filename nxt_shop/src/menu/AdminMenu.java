package menu;

import product.Product;
import shop_item.User;
import shop_item.UserBills;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    public void runAdminMenu(Scanner scanner, Resource resource) {
        boolean check = true;
        int id = -1;
        while (check) {
            int choice = -1;
            resource.printer.menu.printAdminPage();
            String string = scanner.nextLine();
            if (resource.input.validate.validateAdminMenuChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    runAddProductMenu(scanner, resource);
                    break;
                case 2:
                    id = resource.input.productInput.inputId(resource, scanner);
                    if (id != -1) {
                        Product product = resource.input.productInput.updateProduct(id, resource, scanner);
                        resource.manager.product.update(id, product);
                        resource.manager.product.setStaticNumber();
                        resource.printer.success.productUpdateSuccessfully();
                    }
                    break;
                case 3:
                    id = resource.input.productInput.inputId(resource, scanner);
                    if (id != -1) {
                        resource.manager.product.delete(id);
                        resource.manager.product.setStaticNumber();
                        resource.printer.success.productDeleteSuccessfully();
                    }
                    break;
                case 4:
                    resource.manager.product.displayAll(resource);
                    break;
                case 5:
                    resource.manager.product.displayByPrice(resource);
                    break;
                case 6:
                    runUserManagerMenu(resource, scanner);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runAddProductMenu(Scanner scanner, Resource resource) {
        boolean check = true;
        while (check) {
            int choice = -1;
            resource.printer.menu.printAddProductMenu();
            String string = scanner.nextLine();
            if (resource.input.validate.validateAdminMenuChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    Product product = resource.input.productInput.inputAddProduct(resource, scanner, choice);
                    resource.manager.product.add(product);
                    resource.printer.success.addSuccessfully();
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runUserManagerMenu(Resource resource, Scanner scanner) {
        boolean check = true;
        int choice = -1;
        String string;
        while (check) {
            resource.printer.menu.printUserManagerMenu();
            string = scanner.nextLine();
            if (resource.input.validate.validateUserManagerChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    List<User> users = resource.manager.user.getUsers();
                    resource.printer.table.printUserList(users);
                    break;
                case 2:
                    String username = resource.input.loginAndUserInput.inputUsername(scanner);
                    if (resource.input.loginAndUserInput.checkExistUserName(username, resource)) {
                        User user = resource.manager.user.getUserByName(username);
                        UserBills userBills = resource.manager.bill.getUserBillsByUser(user);
                        resource.printer.table.printBill(userBills, user, "bill");
                    } else {
                        resource.printer.error.userNotFound();
                    }
                    break;
                case 3:
                    int totalIncome = resource.manager.bill.getTotalIncome();
                    resource.printer.notification.totalIncomeDisplay(totalIncome);
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
