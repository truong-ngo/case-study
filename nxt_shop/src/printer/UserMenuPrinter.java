package printer;

import shop_item.User;

public class UserMenuPrinter {
    public void searchPrinter() {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[Guest Page]──────────────────┐");
        System.out.printf(format, "GUEST");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Search by name.");
        System.out.printf(format, "▶[2]. Search by brand.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printCartManager(User user) {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[User Page]───────────────────┐");
        System.out.printf(format, "USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Display cart.");
        System.out.printf(format, "▶[2]. Clear cart.");
        System.out.printf(format, "▶[3]. Payment.");
        System.out.printf(format, "▶[4]. Display bill.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printViewProductMenu(User user) {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[User Page]───────────────────┐");
        System.out.printf(format, "USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Add product to cart.");
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
        System.out.printf(format, "▶[3]. User information.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printAccountUpdate(User user) {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[User Page]───────────────────┐");
        System.out.printf(format, "USER: " + user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Update email.");
        System.out.printf(format, "▶[2]. Update phone number.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printUserInformation(User user) {
        String format = "│ %-12s │ %-30s │\n";
        System.out.println("User Info:");
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "User name", user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "Email", user.getEmail());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "Phone number", user.getPhoneNumber());
        System.out.println("└───────────────────────────────────────────────┘");
    }

    public void updateSuccessfully() {
        System.out.println("✅ Update successfully");
    }
    public void updateFail() {
        System.out.println("⛔ Invalid input data");
    }
}
