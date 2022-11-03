package printer;

import user.User;

public class UserMenuPrinter {
    public void searchPrinter() {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[Guest Page]──────────────────┐");
        System.out.printf(format, "GUEST");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Search by Name.");
        System.out.printf(format, "▶[2]. Search by Brand.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printCartManager(User user) {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[User Page]───────────────────┐");
        System.out.printf(format, "USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Display Cart.");
        System.out.printf(format, "▶[2]. Clear Cart.");
        System.out.printf(format, "▶[3]. Payment.");
        System.out.printf(format, "▶[4]. Display Bill.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printViewProductMenu(User user) {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[User Page]───────────────────┐");
        System.out.printf(format, "USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Add Product to Cart.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printAccountManager(User user) {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[User Page]───────────────────┐");
        System.out.printf(format, "USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Change password.");
        System.out.printf(format, "▶[2]. Update information.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }
}
