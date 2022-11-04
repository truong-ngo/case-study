package printer;

import shop_item.User;

public class MainMenuPrinter {
    public void printHomePage() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.println("│      --o0o-- WELCOME TO NXT SHOP --o0o--      │");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Guest page.");
        System.out.printf(format, "▶[2]. Sign in.");
        System.out.printf(format, "▶[3]. Sign up.");
        System.out.printf(format, "▶[0]. Exit.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("▶ Enter your choice:");
    }

    public void printGuestPage() {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[Guest Page]──────────────────┐");
        System.out.printf(format, "GUEST");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. View all product.");
        System.out.printf(format, "▶[2]. Search product.");
        System.out.printf(format, "▶[3]. Sort by price.");
        System.out.printf(format, "▶[0]. Return to home page.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printUserPage(User user) {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[User Page]───────────────────┐");
        System.out.printf(format, "USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. View all product.");
        System.out.printf(format, "▶[2]. Search product.");
        System.out.printf(format, "▶[3]. Sort by price.");
        System.out.printf(format, "▶[4]. Cart manager.");
        System.out.printf(format, "▶[5]. Account manager.");
        System.out.printf(format, "▶[0]. Sign out.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printAdminPage() {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[Admin Page]──────────────────┐");
        System.out.printf(format, "ADMIN");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Add product.");
        System.out.printf(format, "▶[2]. Update product.");
        System.out.printf(format, "▶[3]. Delete product.");
        System.out.printf(format, "▶[4]. View all product.");
        System.out.printf(format, "▶[5]. Sort product by price.");
        System.out.printf(format, "▶[6]. User manager.");
        System.out.printf(format, "▶[0]. Sign out.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }
}
