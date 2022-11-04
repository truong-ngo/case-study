package printer;

import product.Product;

import java.util.List;

public class ProductManagerPrinter {
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
    public void productListTitle() {
        System.out.println("⌚ Product list: ");
    }

    public void invalidName() {
        System.out.println("⛔ Invalid name");
    }

    public void invalidBrand() {
        System.out.println("⛔ Invalid brand");
    }

    public void noMatchProduct() {
        System.out.println("⛔ No match product");
    }

    public void searchResult() {
        System.out.println("☑ Search result: ");
    }

    public void invalidData() {
        System.out.println("⛔ Invalid data");
    }

    public void addSuccessfully() {
        System.out.println("✅ Add successfully");
    }
}
