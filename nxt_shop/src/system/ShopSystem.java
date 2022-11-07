package system;

import menu.Menu;

import java.util.Scanner;

public class ShopSystem {
    public Menu menu;

    public ShopSystem() {
        menu = new Menu();
    }

    public void run(Scanner scanner) {
        menu.run(scanner);
    }
}
