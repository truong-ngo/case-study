package menu;

import product.Product;

import java.util.Scanner;

public class AdminMenu {
    public void runAdminMenu(Scanner scanner, Resource resource) {
        boolean check = true;
        while (check) {
            int choice = -1;
            resource.printer.mainMenuPrinter.printAdminPage();
            String string = scanner.nextLine();
            if (resource.input.validate.validateAdminMenuChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    runAddProductMenu(scanner, resource);
                    break;
                case 2:

                    break;
                case 3:
                case 4:
                    resource.manager.getProductManager().displayAll(resource);
                    break;
                case 5:
                    resource.manager.getProductManager().displayByPrice(resource);
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
            resource.printer.adminMenuPrinter.addProductMenuPrinter();
            String string = scanner.nextLine();
            if (resource.input.validate.validateAdminMenuChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    Product product = resource.input.productInput.inputProduct(resource, scanner, choice);
                    resource.manager.getProductManager().add(product);
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
