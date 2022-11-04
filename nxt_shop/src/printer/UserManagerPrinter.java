package printer;

import shop_item.User;

import java.util.List;

public class UserManagerPrinter {
    public void printUser(List<User> users) {
        String header = "│ %-15s │ %-10s │\n";
        String content = "│ %-15s │ %10d │\n";
        System.out.println("┌────────────────────────────────────────────┐");
        System.out.printf(header, "Username", "Password");

        System.out.println("└────────────────────────────────────────────┘");
    }
}
