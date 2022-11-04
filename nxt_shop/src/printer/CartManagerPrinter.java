package printer;

import product.Product;
import shop_item.User;

import java.time.LocalDateTime;
import java.util.Collections;
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
        printCartTable(header, content, footer, cart, sum, products);
    }

    public void printBill(Map<Map<Product, Integer>, LocalDateTime> billItem, User user, String type) {
        System.out.println("\uD83E\uDDFE " + user.getUserName() + " " + type);
        String header = "│ %2s │ %-15s │ %10s │ %10s │ %10s │\n";
        String content = "│ %-2d │ %-15s │ %10d │ %10d │ %10d │\n";
        String footer = "│ %-46s │ %10d │\n";
        Set<Map<Product, Integer>> bills = billItem.keySet();
        int total = 0;
        for (Map<Product, Integer> bill : bills) {
            int sum = 0;
            Set<Product> products = bill.keySet();
            System.out.println("▶ Bill at " + billItem.get(bill));
            sum = printCartTable(header, content, footer, bill, sum, products);
            total += sum;
        }
        System.out.println("Total spent of user " + user.getUserName() + " is " + total);
    }

    public int printCartTable(String header, String content, String footer, Map<Product, Integer> bill, int sum, Set<Product> products) {
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.printf(header, "ID", "Product", "Quantity", "Price", "Total");
        for (Product product : products) {
            System.out.println("├─────────────────────────────────────────────────────────────┤");
            System.out.printf(content, product.getId(), product.getName(), bill.get(product),
                              product.getPrice(), product.getPrice() * bill.get(product));
            sum += product.getPrice() * bill.get(product);
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
