package menu;

import manager.Manager;

import java.util.Scanner;

public class Menu {
    public MainMenu mainMenu;
    public Manager manager;

    public Menu() {
        mainMenu = new MainMenu();
        manager = new Manager();
    }

    public void run(Scanner scanner) {
        mainMenu.run(scanner, manager);
    }
}
