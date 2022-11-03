package menu;

import user.User;

import java.util.Scanner;

public class UserMenu {
    public void runSearchMenu(Scanner scanner, Resource resource) {
        boolean check = true;
        while (check) {
            int choice = -1;
            resource.printer.userMenuPrinter.searchPrinter();
            String string = scanner.nextLine();
            if (resource.input.validateMenuChoice.validateSearchChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String name = resource.input.productInput.inputName(scanner);
                    resource.manager.getProductManager().searchByName(name, resource);
                    break;
                case 2:
                    String brand = resource.input.productInput.inputBrand(scanner);
                    resource.manager.getProductManager().searchByBrand(brand, resource);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runCartMenu(Scanner scanner, Resource resource, User user) {
        boolean check = true;
        while (check) {
            int choice = -1;
            resource.printer.menuPrinter.printUserPage(user);
            String string = scanner.nextLine();
            if (resource.input.validateMenuChoice.validateCartChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    resource.manager.getProductManager().displayAll(resource);
                    runAddToCartMenu(scanner, resource, user);
                    break;
                case 2:
                    runSearchMenu(scanner, resource);
                    runAddToCartMenu(scanner, resource, user);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runAddToCartMenu(Scanner scanner, Resource resource, User user) {
        boolean check = true;
        while (check) {
            resource.printer.userMenuPrinter.printViewProductMenu(user);
            String string = scanner.nextLine();
            int choice = -1;
            if (resource.input.validateMenuChoice.validateAddToCartChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String str = resource.input.cartInput.addToCartInput(scanner);
                    if (resource.input.validateMenuChoice.validateIdChoice(str)) {
                        int id = Integer.parseInt(str);
                        if (resource.manager.getProductManager().checkId(id)) {
                            System.out.println("✅ Add to cart successfully");
                        } else {
                            System.out.println("⛔ Id doesnt exist");
                        }
                    } else {
                        resource.printer.reChoice();
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
