package menu;

import manager.Manager;
import java.util.Scanner;

public class GuestMenu extends AbstractMenu {
    public void run(Scanner scanner, Manager manager) {
        boolean check = true;
        while (check) {
            int choice = -1;
            printer.menu.printGuestPage();
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 3)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.invalidData("choice");
            }
            switch (choice) {
                case 1:
                    printer.notification.itemListTitle();
                    manager.product.displayAll(printer);
                    break;
                case 2:
                    runSearch(scanner, manager);
                    break;
                case 3:
                    printer.notification.itemListTitle();
                    manager.product.displayByPrice(printer);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runSearch(Scanner scanner, Manager manager) {
        boolean check = true;
        while (check) {
            int choice = -1;
            printer.menu.printSearch();
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 2)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.invalidData("choice");
            }
            switch (choice) {
                case 1:
                    String name = input.product.inputStringData(scanner, printer, "name");
                    if (!name.equals("")) {
                        manager.product.searchByName(name, printer);
                    } else {
                        printer.error.pleaseEnterData("name");
                    }
                    break;
                case 2:
                    String brand = input.product.inputStringData(scanner, printer, "brand");
                    if (!brand.equals("")) {
                        manager.product.searchByBrand(brand, printer);
                    } else {
                        printer.error.pleaseEnterData("brand");
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
