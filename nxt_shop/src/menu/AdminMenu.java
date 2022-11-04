package menu;

import product.EarBuds;
import product.Laptop;
import product.Mobile;
import product.Product;

import java.util.Scanner;

public class AdminMenu {
    public void runAdminMenu(Scanner scanner, Resource resource) {
        boolean check = true;
        int id = -1;
        while (check) {
            int choice = -1;
            resource.printer.mainMenuPrinter.printAdminPage();
            String string = scanner.nextLine();
            if (resource.input.validate.validateAdminMenuChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    runAddProductMenu(scanner, resource);
                    break;
                case 2:
                    id = resource.input.productInput.inputId(resource, scanner);
                    if (id != -1) {
                        runUpdateProductMenu(id, resource, scanner);

                    } else {
                        resource.printer.productManagerPrinter.invalidId();
                    }
                    break;
                case 3:
                case 4:
                    resource.manager.getProductManager().displayAll(resource);
                    break;
                case 5:
                    resource.manager.getProductManager().displayByPrice(resource);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runAddProductMenu(Scanner scanner, Resource resource) {
        boolean check = true;
        while (check) {
            int choice = -1;
            resource.printer.adminMenuPrinter.addProductMenuPrinter();
            String string = scanner.nextLine();
            if (resource.input.validate.validateAdminMenuChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    Product product = resource.input.productInput.inputProduct(resource, scanner, choice);
                    resource.manager.getProductManager().add(product);
                    break;
                case 0:
                    check = false;
            }
        }
    }
    public void runUpdateProductMenu(int id, Resource resource, Scanner scanner) {
        if (resource.manager.getProductManager().checkId(id)) {
            Product product = resource.manager.getProductManager().getProductById(id);
            //Product newProduct = updateProcess(resource, product, scanner);

        } else {
            resource.printer.productManagerPrinter.idDoesntExist();
        }
    }

//    public void updateName(String data, Product product) {
//        if (!data.equals("")) {
//            product.setName(data);
//        }
//    }
//
//    public void updateBrand(String data, Product product) {
//        if (!data.equals("")) {
//            product.setBrand(data);
//        }
//    }
//    public void updatePrice(Resource resource, String data, Product product) {
//        boolean check = true;
//        while (check) {
//            if (data.equals("") || resource.input.validate.validateInputNumberData(data)) {
//                if (!data.equals("")) {
//                    int price = Integer.parseInt(data);
//                    product.setPrice(price);
//                }
//                check = false;
//            } else {
//                resource.printer.productManagerPrinter.invalidData();
//            }
//        }
//    }
//
//    public void updateQuantity(Resource resource, String data, Product product) {
//        boolean check = true;
//        while (check) {
//            if (data.equals("") || resource.input.validate.validateInputNumberData(data)) {
//                if (!data.equals("")) {
//                    int price = Integer.parseInt(data);
//                    product.setQuantity(price);
//                }
//                check = false;
//            } else {
//                resource.printer.productManagerPrinter.invalidData();
//            }
//        }
//    }
//
//    public void updateNetworkType(String data, Product product) {
//        if (!data.equals("")) {
//            ((Mobile) product).setNetworkType(data);
//        }
//    }
//
//    public void updateRefreshRate(String data, Product product) {
//        if (!data.equals("")) {
//            ((Mobile) product).setRefreshRate(data);
//        }
//    }
//
//    public void updateScreenSize(String data, Product product) {
//        if (!data.equals("")) {
//            ((Laptop) product).setScreenSize(data);
//        }
//    }
//
//    public void updateKeyboardType(String data, Product product) {
//        if (!data.equals("")) {
//            ((Laptop) product).setKeyBoardType(data);
//        }
//    }
//
//    public void updateConnectType(String data, Product product) {
//        if (!data.equals("")) {
//            ((EarBuds) product).setConnectType(data);
//        }
//    }
//
//    public void updateWaterResistance(Resource resource, String data, Product product) {
//        boolean check = true;
//        while (check) {
//            if (data.equals("") || data.equals("yes") || data.equals("no")) {
//                if (data.equals("yes")) {
//                    ((EarBuds) product).setWaterResistance(true);
//                }
//                if (data.equals("no")) {
//                    ((EarBuds) product).setWaterResistance(false);
//                }
//                check = false;
//            } else {
//                resource.printer.productManagerPrinter.invalidData();
//            }
//        }
//    }
//
//    public Product updateProcess(Resource resource, Product product, Scanner scanner) {
//        updateName(resource.input.productInput.updateData(scanner, "name: " + product.getName()), product);
//        updateBrand(resource.input.productInput.updateData(scanner, "brand" + product.getBrand()), product);
//        updatePrice(resource, resource.input.productInput.updateData(scanner, "price" + product.getPrice()), product);
//        updateQuantity(resource, resource.input.productInput.updateData(scanner, "quantity" + product.getQuantity()), product);
//        if (product instanceof Mobile) {
//            updateNetworkType(resource.input.productInput.updateData(scanner, "network type" + ((Mobile) product).getNetworkType()), product);
//            updateRefreshRate(resource.input.productInput.updateData(scanner, "refresh rate" + ((Mobile) product).getRefreshRate()), product);
//        }
//        if (product instanceof Laptop) {
//            updateScreenSize(resource.input.productInput.updateData(scanner, "screen size" + ((Laptop) product).getScreenSize()), product);
//            updateKeyboardType(resource.input.productInput.updateData(scanner, "keyboard type" + ((Laptop) product).getKeyBoardType()), product);
//        }
//        if (product instanceof EarBuds) {
//            updateConnectType(resource.input.productInput.updateData(scanner, "connect type"), product);
//            String content = (((EarBuds) product).isWaterResistance()) ? "yes" : "no";
//            updateWaterResistance(resource, resource.input.productInput.updateData(scanner, "water resistance" + content), product);
//        }
//        return product;
//    }
}
