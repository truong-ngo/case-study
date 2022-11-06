package printer;

import product.Product;
import shop_item.User;
import shop_item.UserBills;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TablePrinter {
    public void printUserList(List<User> users) {
        String header = "│ %-3s │ %-15s │ %-25s │ %-15s │\n";
        String content = "│ %-3d │ %-15s │ %-25s │ %-15s │\n";
        System.out.println("┌─────────────────────────────────────────────────────────────────────┐");
        System.out.printf(header, "No", "Username", "Email", "Phone number");
        int i = 1;
        for (User user : users) {
            if (user.getRole().equals("ADMIN")) {
                continue;
            }
            System.out.println("├─────────────────────────────────────────────────────────────────────┤");
            System.out.printf(content, i, user.getUserName(), user.getEmail(), user.getPhoneNumber());
            i++;
        }
        System.out.println("└─────────────────────────────────────────────────────────────────────┘");
    }

    public void printCart(Map<Product, Integer> cart, User user, String type) {
        Set<Product> products = cart.keySet();
        int sum = 0;
        String header = "│ %2s │ %-15s │ %10s │ %10s │ %10s │\n";
        String content = "│ %-2d │ %-15s │ %10d │ %10d │ %10d │\n";
        String footer = "│ %-46s │ %10d │\n";
        System.out.println("\uD83D\uDED2 " + user.getUserName() + " " + type);
        printTable(header, content, footer, cart, sum, products);
    }

    public void printBill(UserBills userBills, User user, String type) {
        List<UserBills.Bill> bills = userBills.getBills();
        System.out.println("\uD83E\uDDFE " + user.getUserName() + " " + type);
        String header = "│ %2s │ %-15s │ %10s │ %10s │ %10s │\n";
        String content = "│ %-2d │ %-15s │ %10d │ %10d │ %10d │\n";
        String footer = "│ %-46s │ %10d │\n";
        int total = 0;
        for (UserBills.Bill bill : bills) {
            int sum = 0;
            Map<Product, Integer> billItem = bill.getListItem();
            Set<Product> products = billItem.keySet();
            System.out.println("▶ Bill at " + bill.getPaymentTime());
            sum = printTable(header, content, footer, billItem, sum, products);
            total += sum;
        }
        System.out.println("Total spent of user " + user.getUserName() + " is " + total);
    }

    public int printTable(String header, String content, String footer, Map<Product, Integer> billItem, int sum, Set<Product> products) {
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.printf(header, "ID", "Product", "Quantity", "Price", "Total");
        for (Product product : products) {
            System.out.println("├─────────────────────────────────────────────────────────────┤");
            System.out.printf(content, product.getId(), product.getName(), billItem.get(product),
                    product.getPrice(), product.getPrice() * billItem.get(product));
            sum += product.getPrice() * billItem.get(product);
        }
        System.out.println("├─────────────────────────────────────────────────────────────┤");
        System.out.printf(footer, "Total:", sum);
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        return sum;
    }

    public void printProduct(List<Product> lists) {
        String header = "│ %-2s │ %-10s │ %-10s │ %-15s │ %-8s │ %-10s │ %-57s │\n";
        String content = "│ %-2d │ %-10s │ %-10s │ %-15s │ %-8d │ %10d │ %-57s │\n";
        System.out.println("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.printf(header, "ID", "Name", "Brand", "Category", "Quantity", "Price", "Description");
        for (Product product : lists) {
            System.out.println("├────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤");
            System.out.printf(content, product.getId(), product.getName(), product.getBrand(), product.getCategory().getName(),
                    product.getQuantity(), product.getPrice(), product.getDescription());
        }
        System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
    }

    public void printUserInformation(User user) {
        String format = "│ %-12s │ %-30s │\n";
        System.out.println("\uD83D\uDC64 User information:");
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "User name", user.getUserName());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "Balance", user.getBalance() + " VND");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "Email", user.getEmail());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "Phone number", user.getPhoneNumber());
        System.out.println("└───────────────────────────────────────────────┘");
    }
}
