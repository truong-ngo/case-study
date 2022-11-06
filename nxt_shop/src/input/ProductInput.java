package input;

import manager.GeneralManager;
import printer.GeneralPrinter;
import product.*;

import java.util.List;
import java.util.Scanner;

public class ProductInput {
    public String inputStringData(Scanner scanner, GeneralPrinter printer, String data) {
        printer.inputBox.printInputBox(data);
        return scanner.nextLine();
    }

    public String inputNumberData(Scanner scanner, GeneralPrinter printer, GeneralInput input, String data) {
        String string = null;
        boolean check = true;
        while (check) {
            printer.inputBox.printInputBox(data);
            string = scanner.nextLine();
            if (input.validate.validateNumber(string) || string.equals("")) {
                check = false;
            } else {
                printer.error.invalidData(data);
            }
        }
        return string;
    }

    public String inputBooleanData(Scanner scanner, GeneralPrinter printer, String data) {
        String string = null;
        boolean check = true;
        while (check) {
            printer.inputBox.printInputBox(data);
            string = scanner.nextLine();
            if (string.equals("yes") || string.equals("no") || string.equals("")) {
                check = false;
            } else {
                printer.error.invalidData(data);
            }
        }
        return string;
    }

    public String getStringData(Scanner scanner, GeneralPrinter printer, String data) {
        String string;
        int count = 0;
        while (true) {
            string = inputStringData(scanner, printer, data);
            if (!string.equals("")) {
                return string;
            }
            if (count >= 0) {
                printer.error.invalidData(data);
            }
            count++;
        }
    }

    public int getNumberData(Scanner scanner, GeneralPrinter printer, GeneralInput input, String data) {
        String string;
        int count = 0;
        while (true) {
            string = inputNumberData(scanner, printer, input, data);
            if (!string.equals("")) {
                return Integer.parseInt(string);
            }
            if (count >= 0) {
                printer.error.invalidData(data);
            }
            count++;
        }
    }

    public boolean getBooleanData(Scanner scanner, GeneralPrinter printer, String data) {
        String string;
        int count = 0;
        while (true) {
            string = inputBooleanData(scanner, printer, data);
            if (!string.equals("")) {
                return string.equals("yes");
            }
            if (count >= 0) {
                printer.error.invalidData(data);
            }
            count++;
        }
    }

    public int inputId(Scanner scanner, GeneralPrinter printer, GeneralInput input, GeneralManager manager) {
        printer.inputBox.printInputBox("ID");
        String string = scanner.nextLine();
        if (input.validate.validateNumber(string)) {
            int id = Integer.parseInt(string);
            if (manager.product.checkId(id)) {
                return id;
            } else {
                printer.error.itemDoesntExist("ID");
                return -1;
            }
        } else {
            printer.error.invalidData("ID");
            return -1;
        }
    }

    public Product inputAddProduct(Scanner scanner, GeneralPrinter printer, GeneralInput input,
                                   GeneralManager manager, int choice) {
        Product product = null;
        String name;
        do {
            name = getStringData(scanner, printer, "name");
        } while (manager.product.checkDuplicateName(name));
        String brand = getStringData(scanner, printer, "brand");
        int price = getNumberData(scanner, printer, input, "price");
        int quantity = getNumberData(scanner, printer, input, "quantity");
        Category category;
        switch (choice) {
            case 1:
                String networkType = getStringData(scanner, printer, "network type");
                String refreshRate = getStringData(scanner, printer, "refresh rate");
                category = new Category("Mobile");
                product = new Mobile(name, brand, price, quantity, category, networkType, refreshRate);
                break;
            case 2:
                String screenSize = getStringData(scanner, printer, "screen size");
                String keyboardType = getStringData(scanner, printer, "keyboard type");
                category = new Category("Laptop");
                product = new Laptop(name, brand, price, quantity, category, screenSize, keyboardType);
                break;
            case 3:
                String connectType = getStringData(scanner, printer, "connect type");
                boolean waterResistance = getBooleanData(scanner, printer, "is water resistance");
                category = new Category("Earbuds");
                product = new EarBuds(name, brand, price, quantity, category, connectType, waterResistance);
                break;
        }
        return product;
    }

    public Product inputUpdateProduct(int id, Scanner scanner, GeneralPrinter printer,
                                      GeneralInput input, GeneralManager manager) {
        Product product = manager.product.getProductById(id);
        List<Product> list = manager.product.getProducts();
        String name;
        int price, quantity;
        do {
            name = inputStringData(scanner, printer, "name");
        } while (manager.product.checkDuplicateName(name));
        if (name.equals("")) {
            name = product.getName();
        }
        String brand = inputStringData(scanner, printer, "brand");
        if (brand.equals("")) {
            brand = product.getBrand();
        }
        String priceStr = inputNumberData(scanner, printer, input, "price");
        if (priceStr.equals("")) {
            price = product.getPrice();
        } else {
            price = Integer.parseInt(priceStr);
        }
        String quantityStr = inputNumberData(scanner, printer, input, "quantity");
        if (quantityStr.equals("")) {
            quantity = product.getQuantity();
        } else {
            quantity = Integer.parseInt(quantityStr);
        }
        Category category;
        if (product instanceof Mobile) {
            String networkType = inputStringData(scanner, printer, "network type");
            if (networkType.equals("")) {
                networkType = ((Mobile) product).getNetworkType();
            }
            String refreshRate = inputStringData(scanner, printer, "refresh rate");
            if (refreshRate.equals("")) {
                refreshRate = ((Mobile) product).getRefreshRate();
            }
            category = new Category("Mobile");
            product = new Mobile(name, brand, price, quantity, category, networkType, refreshRate);
        }
        if (product instanceof Laptop) {
            String screenSize = getStringData(scanner, printer, "screen size");
            if (screenSize.equals("")) {
                screenSize = ((Laptop) product).getScreenSize();
            }
            String keyboardType = getStringData(scanner, printer, "keyboard type");
            if (keyboardType.equals("")) {
                keyboardType = ((Laptop) product).getKeyBoardType();
            }
            category = new Category("Laptop");
            product = new Mobile(name, brand, price, quantity, category, screenSize, keyboardType);
        }
        if (product instanceof EarBuds) {
            String connectType = inputStringData(scanner, printer, "connect type");
            if (connectType.equals("")) {
                connectType = ((EarBuds) product).getConnectType();
            }
            String waterResistanceStr = inputBooleanData(scanner, printer, "is water resistance");
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
}
