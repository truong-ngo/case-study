package printer;

import shop_item.User;

public class MenuPrinter {
    public void printHomePage() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.println("│      --o0o-- WELCOME TO NXT SHOP --o0o--      │");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Guest page.");
        System.out.printf(format, "▶[2]. Login.");
        System.out.printf(format, "▶[3]. Signup.");
        System.out.printf(format, "▶[0]. Exit.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("▶ Enter your choice:");
    }

    public void printGuestPage() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "\uD83D\uDC64 GUEST");
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
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "\uD83D\uDC64 USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. View all product.");
        System.out.printf(format, "▶[2]. Search product.");
        System.out.printf(format, "▶[3]. Sort by price.");
        System.out.printf(format, "▶[4]. Cart manager.");
        System.out.printf(format, "▶[5]. Account manager.");
        System.out.printf(format, "▶[6]. Chat with admin.");
        System.out.printf(format, "▶[0]. Sign out.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printUserManager() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "\uD83D\uDC64 ADMIN");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Display user list.");
        System.out.printf(format, "▶[2]. View bill by user.");
        System.out.printf(format, "▶[3]. Display total income.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printLogin() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "⏩ LOGIN");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Login.");
        System.out.printf(format, "▶[2]. Forgot password?.");
        System.out.printf(format, "▶[0]. Return to home page.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printSignup() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "✍ SIGNUP");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Signup.");
        System.out.printf(format, "▶[0]. Return to home page.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printSearch() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "\uD83D\uDC64 GUEST");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Search by name.");
        System.out.printf(format, "▶[2]. Search by brand.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printCartManager(User user) {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "\uD83D\uDC64 USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Display cart.");
        System.out.printf(format, "▶[2]. Clear cart.");
        System.out.printf(format, "▶[3]. Checkout your cart.");
        System.out.printf(format, "▶[4]. Display bill.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printViewProduct(User user) {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "\uD83D\uDC64 USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Add product to cart.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printAccountManager(User user) {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "\uD83D\uDC64 USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Change password.");
        System.out.printf(format, "▶[2]. Update information.");
        System.out.printf(format, "▶[3]. Add money to your account.");
        System.out.printf(format, "▶[4]. User information.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printAdminPage() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "\uD83D\uDC64 ADMIN");
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

    public void printAddProduct() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "\uD83D\uDC64 ADMIN");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Add mobile.");
        System.out.printf(format, "▶[2]. Add laptop.");
        System.out.printf(format, "▶[3]. Add earbuds.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printUserChat(User user) {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "\uD83D\uDC64 USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Enter message.");
        System.out.printf(format, "▶[2]. Refresh.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }
}
