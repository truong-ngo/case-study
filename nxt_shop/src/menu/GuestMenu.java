package menu;

import manager.GeneralManager;

import java.util.Scanner;

public class GuestMenu extends AbstractMenu {
    public void run(Scanner scanner, Resource resource, GeneralManager manager) {
        boolean check = true;
        while (check) {
            String string;
            int choice = -1;
            printer.menu.printGuestPageMenu();
            string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 3)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    printer.notification.productListTitle();
                    manager.product.displayAll(printer);
                    break;
                case 2:
                    runSearch(scanner, manager);
                    break;
                case 3:
                    printer.notification.productListTitle();
                    manager.product.displayByPrice(resource);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runSearch(Scanner scanner, GeneralManager manager) {
        boolean check = true;
        while (check) {
            int choice = -1;
            printer.menu.printSearchMenu();
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 2)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    String name = input.productInput.inputStringData(scanner, "name");
                    if (!name.equals("")) {
                        manager.product.searchByName(name, printer, input);
                    } else {
                        printer.notification.pleaseFillName();
                    }
                    break;
                case 2:
                    String brand = input.productInput.inputStringData(scanner, "brand");
                    if (!brand.equals("")) {
                        manager.product.searchByBrand(brand, printer, input);
                    } else {
                        printer.notification.pleaseFillBrand();
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
