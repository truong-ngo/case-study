package input;

import menu.Resource;
import product.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductInput {
    public String inputStringData(Scanner scanner, String type) {
        System.out.println("⌨ Enter " + type + ": ");
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
                resource.printer.error.invalidData();
            }
            count++;
        }
    }

    public String inputBooleanData(Resource resource, Scanner scanner, String type) {
        String string = null;
        boolean check = true;
        while (check) {
            System.out.println("⌨ " + type + ": ");
            string = scanner.nextLine();
            if (string.equals("yes") || string.equals("no") || string.equals("")) {
                check = false;
            } else {
                resource.printer.error.invalidData();
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
                resource.printer.error.invalidData();
            }
            count++;
        }
    }

    public String inputNumberData(Resource resource, Scanner scanner, String type) {
        String string = null;
        boolean check = true;
        while (check) {
            System.out.println("⌨ Enter " + type + ": ");
            string = scanner.nextLine();
            if (resource.input.validate.validateNumber(string) || string.equals("")) {
                check = false;
            } else {
                resource.printer.error.invalidData();
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
                resource.printer.error.invalidData();
            }
            count++;
        }
    }

    public int inputId(Resource resource, Scanner scanner) {
        System.out.println("⌨ Enter id: ");
        String string = scanner.nextLine();
        if (resource.input.validate.validateNumber(string)) {
            int id = Integer.parseInt(string);
            if (resource.manager.getProduct().checkId(id)) {
                return id;
            } else {
                resource.printer.error.idDoesntExist();
                return -1;
            }
        } else {
            resource.printer.error.invalidId();
            return -1;
        }
    }

    public Product inputAddProduct(Resource resource, Scanner scanner, int choice) {
        Product product = null;
        List<Product> list = resource.manager.getProduct().getProducts();
        String name;
        do {
            name = getStringData(resource, scanner, "name");
        } while (checkDuplicateName(list, name));
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
                break;
            case 2:
                String screenSize = getStringData(resource, scanner, "screen size");
                String keyboardType = getStringData(resource, scanner, "keyboard type");
                category = new Category("Laptop");
                product = new Laptop(name, brand, price, quantity, category, screenSize, keyboardType);
                break;
            case 3:
                String connectType = getStringData(resource, scanner, "connect type");
                boolean waterResistance = getBooleanData(resource, scanner, "is water resistance");
                category = new Category("Earbuds");
                product = new EarBuds(name, brand, price, quantity, category, connectType, waterResistance);
                break;
        }
        return product;
    }

    public Product updateProduct(int id, Resource resource, Scanner scanner) {
        Product product = resource.manager.getProduct().getProductById(id);
        List<Product> list = resource.manager.getProduct().getProducts();
        String name;
        int price, quantity;
        do {
            name = inputStringData(scanner, "name");
        } while (checkDuplicateName(list, name));
        if (name.equals("")) {
            name = product.getName();
        }
        String brand = inputStringData(scanner, "brand");
        if (brand.equals("")) {
            brand = product.getBrand();
        }
        String priceStr = inputNumberData(resource, scanner, "price");
        if (priceStr.equals("")) {
            price = product.getPrice();
        } else {
            price = Integer.parseInt(priceStr);
        }
        String quantityStr = inputNumberData(resource, scanner, "quantity");
        if (quantityStr.equals("")) {
            quantity = product.getQuantity();
        } else {
            quantity = Integer.parseInt(quantityStr);
        }
        Category category;
        if (product instanceof Mobile) {
            String networkType = inputStringData(scanner, "network type");
            if (networkType.equals("")) {
                networkType = ((Mobile) product).getNetworkType();
            }
            String refreshRate = inputStringData(scanner, "refresh rate");
            if (refreshRate.equals("")) {
                refreshRate = ((Mobile) product).getRefreshRate();
            }
            category = new Category("Mobile");
            product = new Mobile(name, brand, price, quantity, category, networkType, refreshRate);
        }
        if (product instanceof Laptop) {
            String screenSize = getStringData(resource, scanner, "screen size");
            if (screenSize.equals("")) {
                screenSize = ((Laptop) product).getScreenSize();
            }
            String keyboardType = getStringData(resource, scanner, "keyboard type");
            if (keyboardType.equals("")) {
                keyboardType = ((Laptop) product).getKeyBoardType();
            }
            category = new Category("Laptop");
            product = new Mobile(name, brand, price, quantity, category, screenSize, keyboardType);
        }
        if (product instanceof EarBuds) {
            String connectType = inputStringData(scanner, "connect type");
            if (connectType.equals("")) {
                connectType = ((EarBuds) product).getConnectType();
            }
            String waterResistanceStr = inputBooleanData(resource, scanner, "is water resistance");
            boolean waterResistance;
            if (waterResistanceStr.equals("")) {
                waterResistance = ((EarBuds) product).isWaterResistance();
            } else {
                waterResistance = waterResistanceStr.equals("yes");
            }
            category = new Category("Earbuds");
            product = new EarBuds(name, brand, price, quantity, category, connectType, waterResistance);
        }
        product.setId(id);
        return product;
    }

    public boolean checkDuplicateName(List<Product> list, String name) {
        for (Product product : list) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
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
