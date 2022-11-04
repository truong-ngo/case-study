package menu;

import java.util.Scanner;

public class GuestMenu {

    private final UserMenu submenu;

    public GuestMenu() {
        submenu = new UserMenu();
    }

    public void displayGuestMenu(Scanner scanner, Resource resource) {
        boolean check = true;
        while (check) {
            String str;
            int choice = -1;
            resource.printer.menuPrinter.printGuestPage();
            str = scanner.nextLine();
            if (resource.input.validate.validateGuestPageChoice(str)) {
                choice = Integer.parseInt(str);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    resource.printer.productManagerPrinter.productListTitle();
                    resource.manager.getProductManager().displayAll(resource);
                    break;
                case 2:
                    submenu.runSearchMenu(scanner, resource);
                    break;
                case 3:
                    resource.printer.productManagerPrinter.productListTitle();
                    resource.manager.getProductManager().displayByPrice(resource);
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
