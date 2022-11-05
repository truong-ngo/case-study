package printer;

import product.Product;
import shop_item.User;
import shop_item.UserBills;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CartManagerPrinter {
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

    public void paymentSuccessfully() {
        System.out.println("✅ Payment successfully");
    }

    public void cartClearSuccessfully() {
        System.out.println("✅ Cart clear successfully");
    }

    public void cartIsEmpty() {
        System.out.println("⏰ Cart is Empty");
    }
}
