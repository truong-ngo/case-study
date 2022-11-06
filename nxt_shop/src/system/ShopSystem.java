package system;

import menu.GeneralMenu;

import java.util.Scanner;

public class ShopSystem {
    public GeneralMenu menu;

    public ShopSystem() {
        menu = new GeneralMenu();
    }

    public void run(Scanner scanner) {
        menu.run(scanner);
    }
}
