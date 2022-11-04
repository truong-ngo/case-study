package printer;

import java.util.Scanner;

public class AdminMenuPrinter {
    public void addProductMenuPrinter() {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[Admin Page]──────────────────┐");
        System.out.printf(format, "ADMIN");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Add mobile.");
        System.out.printf(format, "▶[2]. Add laptop.");
        System.out.printf(format, "▶[3]. Add earbuds.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }
}
