package input;

import product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductInput {
    public String inputName(Scanner scanner) {
        System.out.println("⌨ Enter name: ");
        return scanner.nextLine();
    }

    public String inputBrand(Scanner scanner) {
        System.out.println("⌨ Enter brand: ");
        return scanner.nextLine();
    }

    public List<Product> checkName(String name, List<Product> products) {
        List<Product> searchLists = new ArrayList<>();
        for (Product product : products) {
            String value = name.toLowerCase();
            String productName = product.getName().toLowerCase();
            if (productName.contains(value)) {
                searchLists.add(product);
            }
        }
        return searchLists;
    }

    public List<Product> checkBrand(String name, List<Product> products) {
        List<Product> searchLists = new ArrayList<>();
        for (Product product : products) {
            String value = name.toLowerCase();
            String brand = product.getBrand().toLowerCase();
            if (brand.contains(value)) {
                searchLists.add(product);
            }
        }
        return searchLists;
    }
}
