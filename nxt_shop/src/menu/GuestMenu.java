package menu;

import java.util.Scanner;

public class GuestMenu {
    public void runGuestMenu(Scanner scanner, Resource resource) {
        boolean check = true;
        while (check) {
            String string;
            int choice = -1;
            resource.printer.menu.printGuestPageMenu();
            string = scanner.nextLine();
            if (resource.input.validate.validateGuestPageChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    resource.printer.notification.productListTitle();
                    resource.manager.product.displayAll(resource);
                    break;
                case 2:
                    runGuestSearchMenu(scanner, resource);
                    break;
                case 3:
                    resource.printer.notification.productListTitle();
                    resource.manager.product.displayByPrice(resource);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runGuestSearchMenu(Scanner scanner, Resource resource) {
        boolean check = true;
        while (check) {
            int choice = -1;
            resource.printer.menu.printSearchMenu();
            String string = scanner.nextLine();
            if (resource.input.validate.validateSearchChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    String name = resource.input.productInput.inputStringData(scanner, "name");
                    if (!name.equals("")) {
                        resource.manager.product.searchByName(name, resource);
                    } else {
                        resource.printer.notification.pleaseFillName();
                    }
                    break;
                case 2:
                    String brand = resource.input.productInput.inputStringData(scanner, "brand");
                    if (!brand.equals("")) {
                        resource.manager.product.searchByBrand(brand, resource);
                    } else {
                        resource.printer.notification.pleaseFillBrand();
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
