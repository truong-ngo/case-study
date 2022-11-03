package printer;

import product.Product;
import user.User;

import java.util.Map;
import java.util.Set;

public class CartManagerPrinter {
    public void printCart(Map<Product, Integer> cart, User user, String type) {
        Set<Product> products = cart.keySet();
        int sum = 0;
        String header = "│ %2s │ %-15s │ %10s │ %10s │ %10s │\n";
        String content = "│ %-2d │ %-15s │ %10d │ %10d │ %10d │\n";
        String footer = "│ %-46s │ %10d │\n";
        System.out.println(user.getUserName() + " " + type);
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.printf(header, "ID", "Product", "Quantity", "Price", "Total");
        for (Product product : products) {
            System.out.println("├─────────────────────────────────────────────────────────────┤");
            System.out.printf(content, product.getId(), product.getName(), cart.get(product),
                              product.getPrice(), product.getPrice() * cart.get(product));
            sum += product.getPrice() * cart.get(product);
        }
        System.out.println("├─────────────────────────────────────────────────────────────┤");
        System.out.printf(footer, "Total:", sum);
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }

    public void paymentSuccessfully() {
        System.out.println("✅ Payment successfully");
    }

    public void cartClearSuccessfully() {
        System.out.println("✅ Cart clear successfully");
    }

    public void cartIsEmpty() {
        System.out.println("✅ Cart is Empty");
    }
}
