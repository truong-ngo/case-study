package menu;

import manager.Manager;
import java.util.Scanner;

public class GuestMenu extends AbstractMenu {
    private static GuestMenu instance;

    private GuestMenu() {

    }

    public static GuestMenu getInstance() {
        if (instance == null) {
            instance = new GuestMenu();
        }
        return instance;
    }
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
                    runSearch(scanner, manager, "GUEST");
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

    public void runSearch(Scanner scanner, Manager manager, String type) {
        boolean check = true;
        while (check) {
            int choice = -1;
            printer.menu.printSearch(type);
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 3)) {
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
                case 3:
                    String category = input.product.inputStringData(scanner, printer, "brand");
                    if (!category.equals("")) {
                        manager.product.searchByCategory(category, printer);
                    } else {
                        printer.error.pleaseEnterData("category");
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
