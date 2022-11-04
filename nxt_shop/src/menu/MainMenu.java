package menu;

import java.util.Scanner;

public class MainMenu {
    private final GuestMenu guestMenu;
    private final LoginMenu loginMenu;
    public MainMenu() {
        guestMenu = new GuestMenu();
        loginMenu = new LoginMenu();
    }
    public void displayMainMenu(Scanner scanner, Resource resource) {
        String str;
        int choice = -1;
        while (true) {
            resource.printer.mainMenuPrinter.printHomePage();
            str = scanner.nextLine();
            if (resource.input.validate.validateHomePageChoice(str)) {
                choice = Integer.parseInt(str);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    guestMenu.displayGuestMenu(scanner, resource);
                    break;
                case 2:
                    loginMenu.displayLoginMenu(scanner, resource);
                    break;
                case 3:
                    loginMenu.displaySignUpMenu(scanner, resource);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
