package menu;

import manager.GeneralManager;

import java.util.Scanner;

public class GeneralMenu {
    public MainMenu mainMenu;
    public GeneralManager manager;

    public GeneralMenu() {
        mainMenu = new MainMenu();
        manager = new GeneralManager();
    }

    public void run(Scanner scanner) {
        mainMenu.run(scanner, manager);
    }
}
