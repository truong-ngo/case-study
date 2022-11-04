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
    public String inputStringData(Scanner scanner, String type) {
        System.out.println("⌨ Enter " + type + " : ");
        return scanner.nextLine();
    }

    public String getStringData(Resource resource, Scanner scanner, String type) {
        String string;
        int count = 0;
        while (true) {
            string = inputStringData(scanner, type);
            if (!string.equals("")) {
                return string;
            }
            if (count >= 0) {
                resource.printer.productManagerPrinter.invalidData();
            }
            count++;
        }
    }

    public String inputBooleanData(Resource resource, Scanner scanner, String type) {
        String string = null;
        boolean check = true;
        while (check) {
            System.out.println("⌨ " + type + " : ");
            string = scanner.nextLine();
            if (string.equals("yes") || string.equals("no") || string.equals("")) {
                check = false;
            } else {
                resource.printer.productManagerPrinter.invalidData();
            }
        }
        return string;
    }

    public boolean getBooleanData(Resource resource, Scanner scanner, String type) {
        String string;
        int count = 0;
        while (true) {
            string = inputBooleanData(resource, scanner, type);
            if (!string.equals("")) {
                return string.equals("yes");
            }
            if (count >= 0) {
                resource.printer.productManagerPrinter.invalidData();
            }
            count++;
        }
    }



    public String inputNumberData(Resource resource, Scanner scanner, String type) {
        String string = null;
        boolean check = true;
        while (check) {
            System.out.println("⌨ Enter " + type + " : ");
            string = scanner.nextLine();
            if (resource.input.validate.validateInputNumberData(string) || string.equals("")) {
                check = false;
            } else {
                resource.printer.productManagerPrinter.invalidData();
            }
        }
        return string;
    }

    public int getNumberData(Resource resource, Scanner scanner, String type) {
        String string;
        int count = 0;
        while (true) {
            string = inputNumberData(resource, scanner, type);
            if (!string.equals("")) {
                return Integer.parseInt(string);
            }
            if (count >= 0) {
                resource.printer.productManagerPrinter.invalidData();
            }
            count++;
        }
    }

    public int inputId(Resource resource, Scanner scanner) {
        System.out.println("⌨ Enter id: ");
        String string = scanner.nextLine();
        if (resource.input.validate.validateInputNumberData(string)) {
            return Integer.parseInt(string);
        } else {
            return -1;
        }
    }

    public Product inputProduct(Resource resource, Scanner scanner, int choice) {
        Product product = null;
        String name = getStringData(resource, scanner, "name");
        String brand = getStringData(resource, scanner, "brand");
        int price = getNumberData(resource, scanner, "price");
        int quantity = getNumberData(resource, scanner, "quantity");
        Category category;
        switch (choice) {
            case 1:
                String networkType = getStringData(resource, scanner, "network type");
                String refreshRate = getStringData(resource, scanner, "refresh rate");
                category = new Category("Mobile");
                product = new Mobile(name, brand, price, quantity, category, networkType, refreshRate);
                resource.printer.productManagerPrinter.addSuccessfully();
                break;
            case 2:
                String screenSize = getStringData(resource, scanner, "screen size");
                String keyboardType = getStringData(resource, scanner, "keyboard type");
                category = new Category("Laptop");
                product = new Mobile(name, brand, price, quantity, category, screenSize, keyboardType);
                resource.printer.productManagerPrinter.addSuccessfully();
                break;
            case 3:
                String connectType = getStringData(resource, scanner, "connect type");
                boolean waterResistance = getBooleanData(resource, scanner, "is water resistance");
                category = new Category("Earbuds");
                product = new EarBuds(name, brand, price, quantity, category, connectType, waterResistance);
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
