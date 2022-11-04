package input;

import menu.Resource;
import product.Category;
import product.EarBuds;
import product.Mobile;
import product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductInput {
    public String inputStringData(Resource resource, Scanner scanner, String type) {
        String string = null;
        boolean check = true;
        while (check) {
            System.out.println("⌨ Enter " + type + " : ");
            string = scanner.nextLine();
            if (!string.equals("")) {
                check = false;
            } else {
                resource.printer.productManagerPrinter.invalidData();
            }
        }
        return string;
    }

    public boolean inputBooleanData(Resource resource, Scanner scanner, String type) {
        String string = null;
        boolean check = true;
        while (check) {
            System.out.println("⌨ " + type + " : ");
            string = scanner.nextLine();
            if (string.equals("yes") || string.equals("no")) {
                check = false;
            } else {
                resource.printer.productManagerPrinter.invalidData();
            }
        }
        return string.equals("yes");
    }

    public int inputNumberData(Resource resource, Scanner scanner, String type) {
        String string = null;
        boolean check = true;
        while (check) {
            System.out.println("⌨ Enter " + type + " : ");
            string = scanner.nextLine();
            if (resource.input.validate.validateInputNumberData(string)) {
                check = false;
            } else {
                resource.printer.productManagerPrinter.invalidData();
            }
        }
        return Integer.parseInt(string);
    }

    public Product inputProduct(Resource resource, Scanner scanner, int choice) {
        Product product = null;
        String name = inputStringData(resource, scanner, "name");
        String brand = inputStringData(resource, scanner, "brand");
        int price = inputNumberData(resource ,scanner, "price");
        int quantity = inputNumberData(resource ,scanner, "quantity");
        Category category;
        switch (choice) {
            case 1:
                String networkType = inputStringData(resource, scanner, "network type");
                String refreshRate = inputStringData(resource, scanner, "refresh rate");
                category = new Category("Mobile");
                product = new Mobile(name, brand, price, quantity, category, networkType, refreshRate);
                resource.printer.productManagerPrinter.addSuccessfully();
                break;
            case 2:
                String screenSize = inputStringData(resource, scanner, "screen size");
                String keyboardType = inputStringData(resource, scanner, "keyboard type");
                category = new Category("Laptop");
                product = new Mobile(name, brand, price, quantity, category, screenSize, keyboardType);
                resource.printer.productManagerPrinter.addSuccessfully();
                break;
            case 3:
                String connectType = inputStringData(resource, scanner, "connect type");
                boolean isWaterResistance = inputBooleanData(resource, scanner, "is water resistance");
                category = new Category("Earbuds");
                product = new EarBuds(name, brand, price, quantity, category, connectType, isWaterResistance);
                resource.printer.productManagerPrinter.addSuccessfully();
                break;
        }
        return product;
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
