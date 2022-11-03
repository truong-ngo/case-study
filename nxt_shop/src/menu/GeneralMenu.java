package menu;

import java.util.Scanner;

public class GeneralMenu {
    public MainMenu mainMenu;
    public Resource resource;

    public GeneralMenu() {
        mainMenu = new MainMenu();
        resource = new Resource();
    }

    public void display(Scanner scanner) {
        mainMenu.displayMainMenu(scanner, resource);
    }
}
