package menu;

import product.Product;

import java.util.Scanner;

public class AdminMenu {
    public void runAdminMenu(Scanner scanner, Resource resource) {
        boolean check = true;
        int id = -1;
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
                    id = resource.input.productInput.inputId(resource, scanner);
                    if (id != -1) {
                        Product product = resource.input.productInput.updateProduct(id, resource, scanner);
                        resource.manager.getProductManager().update(id, product);
                        resource.manager.getProductManager().setStaticNumber();
                        resource.printer.adminMenuPrinter.productUpdateSuccessfully();
                    }
                    break;
                case 3:
                    id = resource.input.productInput.inputId(resource, scanner);
                    if (id != -1) {
                        resource.manager.getProductManager().delete(id);
                        resource.manager.getProductManager().setStaticNumber();
                        resource.printer.adminMenuPrinter.productDeleteSuccessfully();
                    }
                    break;
                case 4:
                    resource.manager.getProductManager().displayAll(resource);
                    break;
                case 5:
                    resource.manager.getProductManager().displayByPrice(resource);
                    break;
                case 6:
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
                    Product product = resource.input.productInput.inputAddProduct(resource, scanner, choice);
                    resource.manager.getProductManager().add(product);
                    resource.printer.productManagerPrinter.addSuccessfully();
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
