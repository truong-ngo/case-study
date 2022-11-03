package system;

import menu.GeneralMenu;

import java.util.Scanner;

public class ShopSystem {
    public GeneralMenu generalMenu;

    public ShopSystem() {
        generalMenu = new GeneralMenu();
    }

    public void run(Scanner scanner) {
        generalMenu.display(scanner);
    }
}
