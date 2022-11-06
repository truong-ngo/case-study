package menu;

import manager.GeneralManager;

import java.util.Scanner;

public class GeneralMenu {
    public MainMenu mainMenu;
    public GeneralManager manager;
    public Resource resource;

    public GeneralMenu() {
        mainMenu = new MainMenu();
        manager = new GeneralManager();
        resource = new Resource();
    }

    public void run(Scanner scanner) {
        mainMenu.run(scanner, resource, manager);
    }
}
