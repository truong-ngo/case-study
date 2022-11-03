package printer;

import user.User;

public class MainMenuPrinter {
    public void printHomePage() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.println("│      --o0o-- WELCOME TO NXT SHOP --o0o--      │");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Guest Page.");
        System.out.printf(format, "▶[2]. Sign In.");
        System.out.printf(format, "▶[3]. Sign Up.");
        System.out.printf(format, "▶[0]. Exit.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("▶ Enter your choice:");
    }

    public void printGuestPage() {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[Guest Page]──────────────────┐");
        System.out.printf(format, "GUEST");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. View All Product.");
        System.out.printf(format, "▶[2]. Search Product.");
        System.out.printf(format, "▶[3]. Sort by Price.");
        System.out.printf(format, "▶[0]. Return to Home Page.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printUserPage(User user) {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[User Page]───────────────────┐");
        System.out.printf(format, "USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. View All Product.");
        System.out.printf(format, "▶[2]. Search Product.");
        System.out.printf(format, "▶[3]. Sort by Price.");
        System.out.printf(format, "▶[4]. Cart Manager.");
        System.out.printf(format, "▶[5]. Account Manager.");
        System.out.printf(format, "▶[0]. Sign Out.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printAdminPage() {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[Admin Page]──────────────────┐");
        System.out.printf(format, "ADMIN");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Add Product.");
        System.out.printf(format, "▶[2]. Update Product.");
        System.out.printf(format, "▶[3]. Delete Product.");
        System.out.printf(format, "▶[4]. Display All Product.");
        System.out.printf(format, "▶[5]. User Manager.");
        System.out.printf(format, "▶[0]. Sign Out.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }
}
